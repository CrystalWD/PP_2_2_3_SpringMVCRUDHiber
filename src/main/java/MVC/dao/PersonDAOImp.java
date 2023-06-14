package MVC.dao;

import MVC.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAOImp implements PersonDAO {
    private static int idCount;
    private List<Person> personsList = new ArrayList<>();

    //Инициализация списка
    {
        personsList.add(new Person(++idCount, "Fingon", "Noldor", "Fingon@mail"));
        personsList.add(new Person(++idCount, "Kurufin", "Istari", "RingsLover@mail"));
        personsList.add(new Person(++idCount, "Thurin", "Turambar", "DagnirGlaurung@doriath"));
        personsList.add(new Person(++idCount, "Morgoth", "Bauglir", "FatesOfArdasUser@angband"));
    }

    public List<Person> getPersonsList(){
        return personsList;
    }

    public Person getPersonById(int id){
        return personsList.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        person.setId(++idCount);
        personsList.add(person);
    }

    @Override
    public void update(int id, Person person) {
        Person updatedPerson = getPersonById(id);
        updatedPerson.setName(person.getName());
        updatedPerson.setLastName(person.getLastName());
        updatedPerson.setMail(person.getMail());
    }

    @Override
    public void delete(int id) {
        personsList.removeIf(p -> p.getId()==id);
    }

}
