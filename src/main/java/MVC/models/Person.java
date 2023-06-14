package MVC.models;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String mail;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Person(int id, String name, String lastName, String mail) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(){

    }
}
