package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PlayerTDG;

public class CricketerMapper {
	
	public static List<Cricketer> findAllCricketers(){
		List<Cricketer> cricketerList = new ArrayList<Cricketer>();
		try {
			ResultSet rs = PlayerTDG.findAllPlayers();
			while(rs.next()){
				if(rs.getString("discriminator").equals("C")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int batting_average = rs.getInt("batting_average");
					Cricketer cricketer = new Cricketer(id, name, batting_average);
					cricketerList.add(cricketer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cricketerList;
	}
		
	public static Cricketer findCricketerById(int cricketerId){
		Cricketer cricketer = null;
		try {
			ResultSet rs = PlayerTDG.findPlayer(cricketerId);
			while(rs.next()){
				if(rs.getString("discriminator").equals("C")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int batting_average = rs.getInt("batting_average");
					cricketer = new Cricketer(id, name, batting_average);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cricketer;
	}
	public static void insertToDB(Cricketer cricketer) throws SQLException{
		PlayerTDG.insertPlayer(cricketer.getId(), cricketer.getName(), "C", null, cricketer.getBatting_average(), 0);
	}
	public static void deleteFromDB(Cricketer cricketer) throws SQLException{
		PlayerTDG.deletePlayer(cricketer.getId());
	}
	public static void updateDB(Cricketer cricketer) throws SQLException{
		PlayerTDG.updatePlayer(cricketer.getId(), cricketer.getName(), "C", null, cricketer.getBatting_average(), 0);
	}
}

