public class Teacher extends User {
    private String type;

    Teacher(String name, String surname, String type) {
        // new User(name, surname);
        super(name, surname);
        this.type = type;
    }

    @Override
    public void doNothing() {
        System.out.println("Non faccio niente in Teacher");
    }

    @Override
    public String toString() {
        return super.toString() + " type:" + this.type;
    }
}
