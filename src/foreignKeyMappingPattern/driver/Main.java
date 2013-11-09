package foreignKeyMappingPattern.driver;

import java.sql.SQLException;

import foreignKeyMappingPattern.domain.*;

public class Main {
	 /**
     * @param args
     */
    public static void main(String[] args) {
    	//Print all data from the table Artists and Album
    	ArtistMapper artistM = new ArtistMapper();
    	AlbumMapper albumM = new AlbumMapper();
    	try {
        	System.out.println("ALL DATA FROM ARTIST");
        	artistM.printArtist();
        	System.out.println("ALL DATA FROM ALBUM");
        	albumM.printAlbum();
    	}catch(SQLException e) {
			e.printStackTrace();
		}	
    	 
    	//Look for the album with the ID = 3
    	long l = 3;
    	Object found = albumM.find(l);
    	if (found != null){
    		Album album = (Album) found;
    		System.out.println("RESULT: " + album.getTitle() + ", " + album.getArtist().getName());
    	} else {
    		System.out.println("not found");
    	}
    	
    	// Updating the Artist and Album
    	try {
    		artistM.updateArtist(3, "Harumi");
    		albumM.updateAlbum(1, "Yume Sekai", 4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
