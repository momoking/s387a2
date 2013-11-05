package identityFieldPattern.driver;

import identityFieldPattern.domain.Person;
import identityFieldPattern.domain.PersonManager;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PersonManager manager = new PersonManager();
        //manager.printAll();
        Object found = manager.find(1);
        if (found != null){
            Person person = (Person) found;
            System.out.println("result:" + person.getName());
        }else{
            System.out.println("not found!");
        }
        
    }
}
