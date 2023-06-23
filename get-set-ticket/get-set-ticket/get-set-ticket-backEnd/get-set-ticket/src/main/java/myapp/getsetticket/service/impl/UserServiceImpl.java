package myapp.getsetticket.service.impl;

import myapp.getsetticket.entity.User;
import myapp.getsetticket.exceptions.UserNotFoundException;
import myapp.getsetticket.repository.UserRepository;
import myapp.getsetticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User savedUser = this.userRepo.save(user);
        savedUser.setPassword("");
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("Requested User "+userId+" Not Found"));
        return user;
    }

    @Override
    public User loginUser(User user) throws UserNotFoundException {
        User userToFind = this.userRepo.findByEmail(user.getEmail());
        if (userToFind != null && userToFind.getPassword().equals(user.getPassword())) {
            user.setPassword("");
            user.setName(userToFind.getName());
            user.setUserId(userToFind.getUserId());
            return user;
        }
        throw new UserNotFoundException("Requested User Not Found");
    }
}
