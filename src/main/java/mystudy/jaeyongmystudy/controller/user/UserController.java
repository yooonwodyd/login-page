package mystudy.jaeyongmystudy.controller.user;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.repository.UserRepository;
import mystudy.jaeyongmystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @PostMapping("/user/login")
    @ResponseBody
    public User UserLogin(@RequestBody User user){
        User newUser = userService.create(user);
        return newUser;
    }


}
