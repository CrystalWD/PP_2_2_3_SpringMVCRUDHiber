package mvc.web.controller;

import mvc.model.User;
import mvc.service.UserService;
import mvc.util.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class UserController {
    private final UserService userServiceImp;
    private final UserValidator userValidator;

    public UserController(UserService userServiceImp, UserValidator userValidator) {
        this.userServiceImp = userServiceImp;
        this.userValidator = userValidator;
    }

    @GetMapping
    public String getPersons(Model model) {
        model.addAttribute("persons", userServiceImp.getPersonsList());
        return "person/list";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable int id, Model model) {
        model.addAttribute("personById", userServiceImp.getUserById(id));
        return "person/single";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "person/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "person/new";
        userServiceImp.save(user);
        return "redirect:/person";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userServiceImp.getUserById(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult,
                         @PathVariable int id) {
        if (bindingResult.hasErrors())
            return "person/edit";
        userServiceImp.update(id, user);
        return "redirect:/person";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userServiceImp.delete(id);
        return "redirect:/person";
    }
}
