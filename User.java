// public class User extends Object
public class User {
    private String name;
    private String surname;

    User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void doNothing() {
        System.out.println("Non faccio niente in User");
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

}
