package mystudy.jaeyongmystudy.service;


import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User login(String name, String password){

        Optional<User> findUserOptional = userRepository.findByName(name);
        User user = findUserOptional.get();
        System.out.println(user.getPassword());
        System.out.println(user.getName());
        System.out.println(user.getRank());

        if(user.getPassword().equals(password)) {
            return user;
        }
        else{
            return null;
        }
    }
    public User create(User user){
        User newUser = User.builder()
                .name(user.getName())
                .password(user.getPassword())
                .rank("1")
                .build();
        userRepository.save(newUser);
        return newUser;
    }



}
