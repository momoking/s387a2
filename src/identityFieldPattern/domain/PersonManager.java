package identityFieldPattern.domain;


import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> person;

    public PersonManager() {
        if (person == null) {
            person = new ArrayList<Person>();
        }
        load();
    }

    private void load() {
        /**
         * Here, normally we would load the data from mysql person table but for
         * the sake of simplicity, I would simulate the loading by filling my
         * obj list like so:
         */
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("person_one");

        Person p2 = new Person();
        p2.setId(2);
        p2.setName("person_two");

        Person p3 = new Person();
        p3.setId(3);
        p3.setName("person_three");

        person.add(p1);
        person.add(p2);
        person.add(p3);

    }

    public void printAll() {
        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i).getId() + person.get(i).getName());
        }
    }

    public Person find(long id) {
        System.out.println("searching for person with id:" + id);
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).getId() == id) {
                return person.get(i);
            }
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
