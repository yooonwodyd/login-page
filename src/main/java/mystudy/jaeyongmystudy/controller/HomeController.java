package mystudy.jaeyongmystudy.controller;

import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {


    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home() {

        return "/home";
    }
}
