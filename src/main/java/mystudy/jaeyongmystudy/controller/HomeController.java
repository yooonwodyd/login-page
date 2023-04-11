package mystudy.jaeyongmystudy.controller;

import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.service.PostsService;
import mystudy.jaeyongmystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {


    private final UserService userService;
    private final PostsService postsService;

    @Autowired
    public HomeController(UserService userService, PostsService postsService) {
        this.userService = userService;
        this.postsService = postsService;
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
            model.addAttribute("list",postsService.postsList());
            return "loginhome";
        }
    }
}
