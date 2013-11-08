package serializedLOBpattern.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonPersist {
	public static void write(Object obj, PreparedStatement ps)
			throws SQLException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(baos);
		oout.writeObject(obj);
		oout.close();
		ps.setBytes(1, baos.toByteArray());
		//ps.setInt(2, 1);
	}
	public static Object read(ResultSet rs, String column)
			throws SQLException, IOException, ClassNotFoundException {
		byte[] buf = rs.getBytes(column);
		if (buf != null) {
			ObjectInputStream objectIn = new ObjectInputStream(
					new ByteArrayInputStream(buf));
			return objectIn.readObject();
		}
		return null;
	}
	public static Connection getOracleJDBCConnection() {
		String userid = "root", password = "";
		String url = "jdbc:mysql://localhost:3306/soen387a2";
		Connection con = null;
		String driverName = "com.mysql.jdbc.Driver"; //for MySql
		
		try 
		{
			// Load the JDBC driver
			Class.forName(driverName);
		} 
		catch (ClassNotFoundException e) 
		{
			// Could not find the database driver
			System.out.println("ClassNotFoundException : "+e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, userid, password);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
	}
}
