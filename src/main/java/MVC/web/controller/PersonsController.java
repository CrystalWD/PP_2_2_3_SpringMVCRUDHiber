package MVC.web.controller;

import MVC.models.Person;
import MVC.service.PersonService;
import MVC.service.PersonServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonsController {
    private final PersonService personServiceImp;


    public PersonsController(PersonService personServiceImp) {
        this.personServiceImp = personServiceImp;
    }

    @GetMapping()
    public String getPersons(Model model) {
        //получаем людей из дао и отправляем на вью
        model.addAttribute("persons", personServiceImp.getPersonsList());
        return "persons/list";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        //передаем 1 человека по его ID из дао и передаем в представление
        model.addAttribute("personById", personServiceImp.getPersonById(id));
        return "persons/single";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "persons/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personServiceImp.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/{edit}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personServiceImp.getPersonById(id));
        return "persons/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personServiceImp.update(id, person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personServiceImp.delete(id);
        return "redirect:/persons";
    }
}
