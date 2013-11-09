package foreignKeyMappingPattern.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DBRegistry;

public class ArtistMapper {
	private ArrayList<Artist> artistList;
	
	public ArtistMapper() {
		if (artistList == null) {
			artistList = new ArrayList<Artist>();
		}
		try {
			loadArtist();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Looks for the Artist
	 * @param id
	 * @return the artist if found, else null
	 */
	public Artist find(Long id) {
		System.out.println("Search album by ID: " + id);
		for (int i =0; i < artistList.size(); i++) {
			if (artistList.get(i).getId() == id) {
				return artistList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Looks for the Artist's ID
	 * @param name
	 * @return artist's id if found, else 0
	 */
	public long findID (String name){
		for (int i =0; i < artistList.size(); i++) {
			if (artistList.get(i).getName().equalsIgnoreCase(name)) {
				return artistList.get(i).getId();
			}
		}
		return 0;
	}

	/**
	 * Add all the data from the database into artistList, the local list
	 */
	public void loadArtist() throws SQLException {
		final String SELECT_SQL = "SELECT * FROM artists";
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
        PreparedStatement ps = con.prepareStatement(SELECT_SQL);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
        	Artist ar = new Artist();
        	ar.setId(result.getLong("id"));
        	ar.setName(result.getString("name"));
        	artistList.add(ar);
        }
	}
	
	/**
	 * Removes all data in the artistList and re-adding the data from the database
	 */
	public void reloadArtist() throws SQLException {
		artistList.clear();
		loadArtist();
	}
	
	/**
	 * Prints all the data from the artistList
	 */
	public void printArtist() throws SQLException {
		reloadArtist();
        for (int i = 0; i < artistList.size(); i++) {
            System.out.println(artistList.get(i));
        }
    }
	
	/**
	 * Gets the data from artistList
	 * @return artistList
	 */
    public ArrayList<Artist> getAll(){
        return artistList;
    }
    
    /**
     * Allow the changes in the name. 
     * Does not allow changes if name is already in the database 
     * @param id, name
     */
    public void updateArtist (long id, String name) throws SQLException {
    	if (findID(name) != 0)
    		System.out.println("There is already such artist name in the database: " + name);
    	else {
    		String n = find(id).getName();
    		final String UPDATE_SQL = "UPDATE artists SET name = ? WHERE id = ?";
    		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, name);
			ps.setLong(2, id);
			ps.executeUpdate();
			System.out.println("Updating the artist name " + n + " to " + name + " completed.");
    	}
    	printArtist();
    }
}
