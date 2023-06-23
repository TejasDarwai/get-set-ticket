package myapp.getsetticket.service;

import myapp.getsetticket.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User loginUser(User user);
}
