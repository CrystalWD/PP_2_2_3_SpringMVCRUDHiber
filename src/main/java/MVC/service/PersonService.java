package MVC.service;

import MVC.models.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getPersonsList();

    public Person getPersonById(int id);

    void save(Person person);

    public void update(int id, Person person);

    public void delete(int id);
}
