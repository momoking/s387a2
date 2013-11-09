package foreignKeyMappingPattern.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DBRegistry;

public class AlbumMapper{
	private ArrayList<Album> albumList;
	
	public AlbumMapper() {
		if (albumList == null) {
			albumList = new ArrayList<Album>();
		}
		try {
			loadAlbum();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Looks for the Album
	 * @param id
	 * @return the album if found, else null
	 */
	public Album find(Long id) {
		for (int i =0; i < albumList.size(); i++) {
			if (albumList.get(i).getId() == id) {
				return albumList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Looks for the Album's ID
	 * @param title
	 * @return album's id if found, else 0
	 */
	public long findID (String title){
		for (int i =0; i < albumList.size(); i++) {
			if (albumList.get(i).getTitle().equalsIgnoreCase(title)) {
				return albumList.get(i).getId();
			}
		}
		return 0;
	}
	
	/**
	 * Add all the data from the database into albumList, the local list
	 */
	public void loadAlbum() throws SQLException {
		final String SELECT_SQL = "SELECT * FROM album";
		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
        PreparedStatement ps = con.prepareStatement(SELECT_SQL);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
        	Album al = new Album();
        	Artist ar = new Artist();
        	al.setId(result.getLong("id"));
        	ar.setId(result.getLong("artID"));
        	ArtistMapper am = new ArtistMapper();			//
        	al.setArtist(am.find(result.getLong("artID")));	//
        	al.setTitle(result.getString("title"));
        	albumList.add(al);
        }
	}
	
	/**
	 * Removes all data in the albumList and re-adding the data from the database
	 */
	public void reloadAlbum() throws SQLException {
		albumList.clear();
		loadAlbum();
	}
	
	/**
	 * Prints all the data from the albumList
	 */
	public void printAlbum() throws SQLException {
		reloadAlbum();
        for (int i = 0; i < albumList.size(); i++) {
            System.out.println(albumList.get(i));
        }
    }
	
	/**
	 * Gets all the data from albumList
	 * @return albumList
	 */
    public ArrayList<Album> getAll(){
        return albumList;
    }
    
    /**
     * Allow the changes in the title and artID. 
     * Does not allow changes if title is already in the database or
     * 						if there is no artID which is the artist's ID (foreign key) 
     * @param id, title, artID
     */
    public void updateAlbum (long id, String title, long artID) throws SQLException {
    	ArtistMapper am = new ArtistMapper();
    	if (findID(title) != 0)
    		System.out.println("The album is already such title in the database: " + title);
    	else if(am.find(artID) == null)
    		System.out.println("There is no such artist ID.");
    	else{
    		String t = find(id).getTitle();
    		long l = find(id).getArtist().getId();
    		System.out.println(t);
    		final String UPDATE_SQL = "UPDATE album SET title = ?, artID = ? WHERE id = ?";
    		Connection con = DBRegistry.getUniqueInstance().getDBConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			ps.setString(1, title);
			ps.setLong(2, artID);
			ps.setLong(3,  id);
			ps.executeUpdate();
			System.out.println("Updating the album title from " + t + " to " + title + " completed.");
			System.out.println("Updating the album's artist ID from " + l + " to " + artID + " completed.");
    	}
    	printAlbum();
    }    
}
