package common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import common.technical.Registry;


public class DBRegistry {
    private static DBRegistry soleInstance;
    private Connection dbConnection;
    
    private DBRegistry() {}

    public static DBRegistry getUniqueInstance(){
        if(soleInstance == null)
            soleInstance = new DBRegistry();
        return soleInstance;
    }
    private void iniDBConnection() {
        try {
//            String dbDriverClass = Registry.getUniqueInstance().getProperty("DbDriver");
//            String dbConnectionString = Registry.getUniqueInstance().getProperty("DbConnectionString");
//            String dbUser = Registry.getUniqueInstance().getProperty("user");
//            String dbPassword = Registry.getUniqueInstance().getProperty("password");
//            Class.forName(dbDriverClass);
//            dbConnection = DriverManager.getConnection("jdbc:" + dbConnectionString, dbUser, dbPassword);
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soen387_A2", "root", "root");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private boolean isConnected() {
        return dbConnection != null;
    }
    
    public Connection getDBConnection() {
        if(!isConnected())
            iniDBConnection();
        return dbConnection;
    }

    public void closeDBConnection() throws SQLException{
        if(dbConnection != null){
            dbConnection.close();
            dbConnection =null;
        }
    }
}
