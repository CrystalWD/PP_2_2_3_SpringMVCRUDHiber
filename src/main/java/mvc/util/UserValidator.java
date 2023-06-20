package mvc.util;

import mvc.model.User;
import mvc.repository.UserRepository;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserRepository personRepository;

    @Autowired
    public UserValidator(UserRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (personRepository.findById(user.getId()).isPresent()) {
            errors.rejectValue("id", "", "This id already taken");
        }
    }
}
