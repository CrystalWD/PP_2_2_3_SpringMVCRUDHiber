package mvc.web.controller;

import mvc.model.User;
import mvc.service.UserService;
import mvc.util.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userServiceImp;
    private final UserValidator userValidator;

    public UserController(UserService userServiceImp, UserValidator userValidator) {
        this.userServiceImp = userServiceImp;
        this.userValidator = userValidator;
    }


    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userServiceImp.getPersonsList());
        return "user/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        model.addAttribute("userById", userServiceImp.getUserById(id));
        return "user/single";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "user/new";
        }
        userServiceImp.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImp.getUserById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        userServiceImp.update(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userServiceImp.delete(id);
        return "redirect:/user";
    }
}
