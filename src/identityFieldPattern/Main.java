package identityFieldPattern;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PersonManager manager = new PersonManager();
        //manager.printAll();
        Person found = manager.find(1);
        System.out.println("result:" + found.getName());
    }
}
