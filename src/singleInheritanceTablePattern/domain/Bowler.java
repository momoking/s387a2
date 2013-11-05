package singleInheritanceTablePattern.domain;

public class Bowler extends Cricketer {
	
	private int bowling_average;

	//this constructed is used when bowler comes out of the database
	public Bowler(int id, String name, int batting_average, int bowling_average) {
		super(id, name, batting_average);
		this.bowling_average = bowling_average;
	}
	public int getBowling_average() {
		return bowling_average;
	}
	public void setBowling_average(int bowling_average) {
		this.bowling_average = bowling_average;
	}
	@Override
	public String toString() {
		return "Bowler_Id: " + this.getId() +" name: " + this.getName() +" batting average: " + 
				this.getBatting_average() + " bowling average: " + this.getBowling_average();
	}

}
