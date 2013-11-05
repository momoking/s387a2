package domain;

public class Footballer extends Player {
	
	private String club;
	
	//this constructed is used when footballer comes out of the database
	public Footballer(int id, String name, String club){
		super(id, name);
		this.club = club;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	@Override
	public String toString() {
		return "Footballer_Id: " + this.getId() +" name: " + this.getName() +" club: " + this.getClub();
	}

}
