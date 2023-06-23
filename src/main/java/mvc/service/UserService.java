package mvc.service;


import mvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getPersonsList();

    User getUserById(int id);

    void save(User person);

    void update(User user);

    void delete(int id);
}
