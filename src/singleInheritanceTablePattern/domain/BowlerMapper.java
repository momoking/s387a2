package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PlayerTDG;

public class BowlerMapper {
	
	public static List<Bowler> findAllBowlers() throws SQLException{
		List<Bowler> bowlerList = new ArrayList<Bowler>();

		ResultSet rs = PlayerTDG.findAllPlayers();
		while(rs.next()){
			if(rs.getString("discriminator").equals("B")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				int bowling_average = rs.getInt("bowling_average");
				Bowler bowler = new Bowler(id, name, batting_average, bowling_average);
				bowlerList.add(bowler);
			}
		}

		return bowlerList;
	}
		
	public static Bowler findBowlerById(int bowlerId) throws SQLException {
		Bowler bowler = null;

		ResultSet rs = PlayerTDG.findPlayer(bowlerId);
		while(rs.next()){
			if(rs.getString("discriminator").equals("B")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				int bowling_average = rs.getInt("bowling_average");
				bowler = new Bowler(id, name, batting_average, bowling_average);
				break;
			}
		}

		return bowler;
	}
	public static void insertToDB(Bowler bowler) throws SQLException{
		PlayerTDG.insertPlayer(bowler.getName(), "B", null, bowler.getBatting_average(), bowler.getBowling_average());
	}
	public static void deleteFromDB(Bowler bowler) throws SQLException{
		PlayerTDG.deletePlayer(bowler.getId());
	}
	public static void updateDB(Bowler bowler) throws SQLException{
		PlayerTDG.updatePlayer(bowler.getId(), bowler.getName(), "B", null, bowler.getBatting_average(), bowler.getBowling_average());
	}
}


