package MVC.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
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
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Person(String name, String last_name, String mail) {
        this.name = name;
        this.last_name = last_name;
        this.mail = mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(){

    }
}
