package singleInheritanceTablePattern.driver;

import java.sql.SQLException;
import java.util.List;

import singleInheritanceTablePattern.domain.*;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Player p1 = new Player(1,"Joe");
		Footballer f1 = new Footballer(2,"Isabelle","Five Stars");
		Cricketer c1 = new Cricketer(3, "Alyssa", 50);
		Bowler b1 = new Bowler(4, "David", 47, 68);
		
		try {
			PlayerMapper.insertToDB(p1);
			FootballerMapper.insertToDB(f1);
			CricketerMapper.insertToDB(c1);
			BowlerMapper.insertToDB(b1);
			
			Footballer f2 =FootballerMapper.findFootballerById(2);
			System.out.println(f2);
			FootballerMapper.deleteFromDB(f1);
			
			//b1.setName("Greate Alexandre");
			//System.out.println(b1);
			
			//BowlerMapper.updateDB(b1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
