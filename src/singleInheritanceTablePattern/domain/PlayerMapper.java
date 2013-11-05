package singleInheritanceTablePattern.domain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import singleInheritanceTablePattern.database.PlayerTDG;



public class PlayerMapper {
	
	public static List<Player> findAllPlayer(){
		List<Player> playerList = new ArrayList<Player>();
		try {
			ResultSet rs = PlayerTDG.findAllPlayers();
			while(rs.next()){
				if(rs.getString("discriminator").equals("P")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Player player = new Player(id, name);
					playerList.add(player);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}
		
	public static Player findPlayerById(int playerId){
		Player player = null;
		try {
			ResultSet rs = PlayerTDG.findPlayer(playerId);
			while(rs.next()){
				if(rs.getString("discriminator").equals("P")){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					player = new Player(id, name);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	public static void insertToDB(Player player) throws SQLException{
		PlayerTDG.insertPlayer(player.getId(), player.getName(), "P", null, 0, 0);
	}
	public static void deleteFromDB(Player player) throws SQLException{
		PlayerTDG.deletePlayer(player.getId());
	}
	public static void updateDB(Player player) throws SQLException{
		PlayerTDG.updatePlayer(player.getId(), player.getName(), "P", null, 0, 0);
	}
	
}
