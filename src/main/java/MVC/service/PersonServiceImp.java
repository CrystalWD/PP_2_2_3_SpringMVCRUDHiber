package MVC.service;

import MVC.dao.PersonDAOImp;
import MVC.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonServiceImp implements PersonService{

    private final PersonDAOImp personDAOImp;
    @Autowired
    PersonServiceImp(PersonDAOImp personDAOImp){
        this.personDAOImp = personDAOImp;
    }


    @Override
    public List<Person> getPersonsList() {
        return personDAOImp.getPersonsList();
    }

    @Override
    public Person getPersonById(int id) {
        return personDAOImp.getPersonById(id);
    }

    @Override
    public void save(Person person) {
        personDAOImp.save(person);
    }

    @Override
    public void update(int id, Person person) {
        personDAOImp.update(id,person);
    }

    @Override
    public void delete(int id) {
        personDAOImp.delete(id);
    }
}
