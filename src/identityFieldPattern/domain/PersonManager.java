package identityFieldPattern.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DBRegistry;

public class PersonManager {

    private ArrayList<Person> personList;

    public PersonManager() {
        if (personList == null) {
            personList = new ArrayList<Person>();
        }
        try {
            load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void load() throws SQLException {
        final String SELECT_SQL = "SELECT * FROM persons";
        Connection con = DBRegistry.getUniqueInstance().getDBConnection();
        PreparedStatement ps = con.prepareStatement(SELECT_SQL);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Person p = new Person();
            p.setId(result.getInt("id"));
            p.setName(result.getString("name"));
            personList.add(p);
        }
    }

    public void printAll() {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }

    public ArrayList<Person> getAll(){
        return personList;
    }
    
    public Person find(long id) {
        System.out.println("SEARCH PERSON BY ID:" + id);
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == id) {
                return personList.get(i);
            }
        }
        return null;
    }

}
