package domain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.PlayerTDG;

public class PlayerMapper {
	
	public static List<Player> findAllPlayer() throws  SQLException {
		List<Player> playerList = new ArrayList<Player>();
		ResultSet rs = PlayerTDG.findAllPlayers();
		while(rs.next()){
			if(rs.getString("discriminator").equals("P")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Player player = new Player(id, name);
				playerList.add(player);
			}
			if(rs.getString("discriminator").equals("F")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String club = rs.getString("club");
				Footballer footballer = new Footballer(id, name, club);
				playerList.add(footballer);
			}
			if(rs.getString("discriminator").equals("C")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				Cricketer cricketer = new Cricketer(id, name, batting_average);
				playerList.add(cricketer);
			}
			if(rs.getString("discriminator").equals("B")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				int bowling_average = rs.getInt("bowling_average");
				Bowler bowler = new Bowler(id, name, batting_average, bowling_average);
				playerList.add(bowler);
			}
		}

		return playerList;
	}
		
	public static List<Player> findPlayerById(int playerId) throws SQLException {
		List<Player> playerList = new ArrayList<Player>();
		
		ResultSet rs = PlayerTDG.findPlayer(playerId);
		while(rs.next()){
			if(rs.getString("discriminator").equals("P")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Player player = new Player(id, name);
				playerList.add(player);
				break;
			}
			if(rs.getString("discriminator").equals("F")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String club = rs.getString("club");
				Footballer footballer = new Footballer(id, name, club);
				playerList.add(footballer);
				break;
			}
			if(rs.getString("discriminator").equals("C")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				Cricketer cricketer = new Cricketer(id, name, batting_average);
				playerList.add(cricketer);
				break;
			}
			if(rs.getString("discriminator").equals("B")){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int batting_average = rs.getInt("batting_average");
				int bowling_average = rs.getInt("bowling_average");
				Bowler bowler = new Bowler(id, name, batting_average, bowling_average);
				playerList.add(bowler);
				break;
			}
		}
		return playerList;
	}
	public static void insertToDB(Player player) throws SQLException{
		PlayerTDG.insertPlayer(player.getName(), "P", null, 0, 0);
	}
	public static void deleteFromDB(int id) throws SQLException{
		PlayerTDG.deletePlayer(id);
	}
	public static void updateDB(Player player) throws SQLException{
		PlayerTDG.updatePlayer(player.getId(), player.getName(), "P", null, 0, 0);
	}
	
}
