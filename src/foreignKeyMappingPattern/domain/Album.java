package foreignKeyMappingPattern.domain;

public class Album {
	private long id;
	private String title;
	private Artist artist;
	
	public Album() {
		id = 0;
		title = "";
		artist = null;
	}
	public Album(Long id, String title, Artist artist) {
		this.id = id;
		this.title = title;
		this.artist = artist;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
        this.id = id;
    }
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	@Override
    public String toString() {
		return "Album [id=" + this.getId() + ", title=" + this.getTitle() + ", artist=" + this.getArtist() + "]";  
	}
}
