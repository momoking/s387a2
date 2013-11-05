package singleInheritanceTablePattern.domain;

public class Cricketer extends Player {

	private int batting_average;
	
	//this constructed is used when cricketer comes out of the database
	public Cricketer(int id, String name, int batting_average) {
		super(id, name);
		this.batting_average = batting_average;
	}
	public int getBatting_average() {
		return batting_average;
	}
	public void setBatting_average(int batting_average) {
		this.batting_average = batting_average;
	}
	@Override
	public String toString() {
		return "Cricketer_Id: " + this.getId() +" name: " + this.getName() +" batting_average: " + 
				this.getBatting_average();
	}

}
