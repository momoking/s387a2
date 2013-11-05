package identityFieldPattern.driver;

import identityFieldPattern.domain.Person;
import identityFieldPattern.domain.PersonManager;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PersonManager manager = new PersonManager();
        System.out.println("BROWSE DATA");
        manager.printAll();
        
        Object found = manager.find(10);
        if (found != null){
            Person person = (Person) found;
            System.out.println("RESULT:" + person.getName());
        }else{
            System.out.println("not found!");
        }
        
    }
}
