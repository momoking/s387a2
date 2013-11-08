package singleInheritanceTablePattern.domain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import singleInheritanceTablePattern.database.PlayerTDG;

public class FootballerMapper {
	
	public static List<Footballer> findAllFootballers(){
		List<Footballer> footballerList = new ArrayList<Footballer>();
		try {
			ResultSet rs = PlayerTDG.findAllPlayers();
			while(rs.next()){
				if(rs.getString("discriminator").equals("F")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String club = rs.getString("club");
					Footballer footballer = new Footballer(id, name, club);
					footballerList.add(footballer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return footballerList;
	}
		
	public static Footballer findFootballerById(int footballerId){
		Footballer footballer = null;
		try {
			ResultSet rs = PlayerTDG.findPlayer(footballerId);
			while(rs.next()){
				if(rs.getString("discriminator").equals("F")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String club = rs.getString("club");
					footballer = new Footballer(id, name, club);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return footballer;
	}
	public static void insertToDB(Footballer footballer) throws SQLException{
		PlayerTDG.insertPlayer(footballer.getName(), "F", footballer.getClub(), 0, 0);
	}
	public static void deleteFromDB(Footballer footballer) throws SQLException{
		PlayerTDG.deletePlayer(footballer.getId());
	}
	public static void updateDB(Footballer footballer) throws SQLException{
		PlayerTDG.updatePlayer(footballer.getId(), footballer.getName(), "F", footballer.getClub(), 0, 0);
	}
}
