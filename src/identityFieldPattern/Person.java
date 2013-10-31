package identityFieldPattern;

public class Person {

    private long id;
    private String name;
    
    public Person(){
        id = 0;
        name = "";
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("bob");
        System.out.println("pid:" + p.getId());
        System.out.println("name:" + p.getName());
    }

}
