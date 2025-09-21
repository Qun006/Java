abstract public class Person {
    private static int autoId = 1;
    private int id;
    private String surname;
    private String name;
    private int age;
    private String email;

    public Person(String surname, String name, int age, String email) {
        this.id = autoId++;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person() {
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Person.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    abstract public String getInfo();
}
