package foreignKeyMappingPattern.domain;

public class Artist {
	private long id;
	private String name;
	
	public Artist () {
		id = 0;
		name = "";
	}
	
	public Artist(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
        this.id = id;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return "Artist [id=" + this.getId() + ", name=" + this.getName() + "]";
    }
}
