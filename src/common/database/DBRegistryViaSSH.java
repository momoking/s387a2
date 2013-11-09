package common.database;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class DBRegistryViaSSH {

    static {
        String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SSHConnection getConnection() {
        Connection connection = null;
        SSHConnection ssHsession = doSshTunnel();
        String databaseName = "soen387d";
        String username = "soen387d";
        String password = "";
        String url = "jdbc:mysql://" + ssHsession.getServer() + ":" + ssHsession.getPort() + "/"
                + databaseName; // for Mysql

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ssHsession.setConnection(connection);
        
        return ssHsession;

    }

    public static void close(ResultSet rs, Statement stmt, SSHConnection ssHsession) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (ssHsession != null)
                ssHsession.getConnection().close();
                ssHsession.getSession().disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void printRs(ResultSet rs) {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            StringBuffer sb = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    String columnName = meta.getColumnName(i);
                    sb.append(columnName + "=");
                    sb.append(rs.getString(columnName) + "  ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSHConnection doSshTunnel() {
        String strSshUser = "haiy_zh"; // SSH loging username
        String strSshPassword = "YOUR ENCS ACCOUNT PASSWORD"; // SSH login password
        String strSshHost = "login.encs.concordia.ca"; // hostname or ip or SSH
                                                        // server
        int nSshPort = 22; // remote SSH host port number
        String strRemoteHost = "clipper.encs.concordia.ca"; // hostname or ip of
                                                            // your database
                                                            // server
        int nLocalPort = findUnusedPort(); // local port number use to bind SSH
                                            // tunnel
        String localServer = "127.0.0.1";
        int nRemotePort = 3306; // remote port number of your database
        System.out.println(strSshPassword);
        System.out.println(nLocalPort);
        final JSch jsch = new JSch();

        int assport = 0;
        Session session=null;
        
        try {
            session = jsch.getSession(strSshUser, strSshHost, nSshPort);
            session.setPassword(strSshPassword);

            final Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            assport = session.setPortForwardingL(nLocalPort, strRemoteHost,
                    nRemotePort);
            System.out.println(assport);

        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        SSHConnection ssHsession = new SSHConnection(session, localServer, assport);
        return ssHsession;
    }

    private static int findUnusedPort() {
        final int startingPort = 1025;
        final int endingPort = 1200;
        for (int port = 1025; port < 1200; port++) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
                return port;
            } catch (IOException e) {
                System.out.println("Port " + port
                        + "is currently in use, retrying port " + port + 1);
            } finally {
                // Clean up
                if (serverSocket != null)
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(
                                "Unable to close socket on port" + port, e);
                    }
            }
        }
        throw new RuntimeException("Unable to find open port between "
                + startingPort + " and " + endingPort);
    }

    

}
