package domain;

public class Player {

	private int id;
	private String name;
	
	//this constructed is used when player comes out of the database
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	//this constructed is used when player goes into the database
	public Player(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Player_Id: " + this.id +" name: " + this.name;
	}

}
