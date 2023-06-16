package MVC.service;

import MVC.models.Person;
import MVC.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    PersonServiceImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersonsList() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.orElse(null);
    }

    @Transactional
    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    @Override
    public void update(int id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    @Transactional
    @Override
    public void delete(int id) {
        personRepository.delete(getPersonById(id));
    }
}
