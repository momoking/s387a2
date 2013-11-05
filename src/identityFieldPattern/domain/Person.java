package identityFieldPattern.domain;

public class Person {

    public long PLACEHOLDER_ID = -1;
    private long id = PLACEHOLDER_ID;
    private String name;

    public Person() {
        // An object that's been created in memory but not saved to the database
        // will not have a value for its key
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

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("bob");
        System.out.println(p);
    }

}
