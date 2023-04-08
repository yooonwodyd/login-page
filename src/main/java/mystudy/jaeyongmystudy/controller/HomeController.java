package mystudy.jaeyongmystudy.controller;

import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {


    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(
            @SessionAttribute(name = "LOGIN_USER",required = false)User loginUser, Model model)
    {
        if(loginUser == null){

            return "home";
        }
        else {

            model.addAttribute("loginUser",loginUser);
            return "home";
        }
    }
}
