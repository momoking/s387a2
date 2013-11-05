package singleInheritanceTablePattern.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.database.DBRegistry;

public class PlayerTDG {
	public static ResultSet findAllPlayers() throws SQLException{
		final String SELECT_SQL = "SELECT * FROM players p";
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
		PreparedStatement ps = con.prepareStatement(SELECT_SQL);
		ResultSet result = ps.executeQuery();
		return result;
	}
	public static ResultSet findPlayer(int id) throws SQLException{
		final String SELECT_SQL = "SELECT * FROM players p WHERE id = ?";
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
		PreparedStatement ps = con.prepareStatement(SELECT_SQL);
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		return result;
	}

	public static void deletePlayer(int id) throws SQLException{
		final String DELETE_SQL = "DELETE FROM players WHERE id = ?";
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
		PreparedStatement ps = con.prepareStatement(DELETE_SQL);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public static void insertPlayer(int id, String name, String discriminator, 
			String club, int batting_average, int bowling_average) throws SQLException{

		Connection con = DBRegistry.getUniqueInstance().getDBConnection();		
		String INSERT_SQL;

		if(discriminator.equals("P")){
			INSERT_SQL ="INSERT INTO players (id,name,discriminator) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, discriminator);
			ps.executeUpdate();
		}
		if(discriminator.equals("F")){
			INSERT_SQL ="INSERT INTO players (id,name,discriminator,club) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, discriminator);
			ps.setString(4, club);				
			ps.executeUpdate();
		}
		if(discriminator.equals("C")){
			INSERT_SQL ="INSERT INTO players (id,name,discriminator,club,batting_average) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, discriminator);
			ps.setString(4, club);		
			ps.setInt(5, batting_average);			
			ps.executeUpdate();
		}
		if(discriminator.equals("B")){
			INSERT_SQL ="INSERT INTO players (id,name,discriminator,club,batting_average," +
					"bowling_average) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, discriminator);
			ps.setString(4, club);		
			ps.setInt(5, batting_average);		
			ps.setInt(6, bowling_average);		
			ps.executeUpdate();
		}
	}
	
	public static void updatePlayer(int id, String name, String discriminator, 
			String club, int batting_average, int bowling_average) throws SQLException{
		
		String UPDATE_SQL;		
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
		
		if(discriminator.equals("P")){
			UPDATE_SQL = "UPDATE players SET name = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		if(discriminator.equals("F")){
			UPDATE_SQL = "UPDATE players SET name = ?, club = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, name);
			ps.setString(2, club);
			ps.setInt(3, id);
			ps.executeUpdate();
		}
		if(discriminator.equals("C")){
			UPDATE_SQL = "UPDATE players SET name = ?, batting_average = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, name);
			ps.setInt(2, batting_average);
			ps.setInt(3, id);
			ps.executeUpdate();
		}
		if(discriminator.equals("B")){
			UPDATE_SQL = "UPDATE players SET name = ?, batting_average = ?, bowling_average =? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, name);
			ps.setInt(2, batting_average);
			ps.setInt(3, bowling_average);
			ps.setInt(4, id);
			ps.executeUpdate();
		}
	}
	
}
