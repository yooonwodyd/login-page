package mystudy.jaeyongmystudy.service;


import mystudy.jaeyongmystudy.controller.entity.UserLoginForm;
import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user) {
        User newUser = new User(user.getUserId(),user.getName(),user.getUser_rank(),user.getPassword());

        userRepository.save(newUser);
        return newUser;
    }

    public User login(UserLoginForm form) {

        User user = userRepository.findByName(form.getName()).orElse(null);
        if (user == null) {
            return null;
        }

        else if(user.getPassword().equals(form.getPassword())) {
            return user;
        }
        else {
            return null;
        }

    }

}




