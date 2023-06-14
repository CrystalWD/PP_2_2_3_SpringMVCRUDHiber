package MVC.dao;

import MVC.models.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> getPersonsList();
    public Person getPersonById(int id);
    public void save(Person person);
    public void update(int id,Person person);
    public void delete(int id);

}
