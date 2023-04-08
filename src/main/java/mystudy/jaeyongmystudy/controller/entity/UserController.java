package mystudy.jaeyongmystudy.controller.entity;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mystudy.jaeyongmystudy.entity.User;
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


    @PostMapping("/user/create")
    public String UserLogin(User user){

        User newUser = userService.create(user);
        return "home";
    }

    @GetMapping("/user/create")
    public String toCreateForm(){
        return "users/new";
    }

    @PostMapping("/user/login")

    public String loginWithHttpSession(@ModelAttribute UserLoginForm form, BindingResult bindingResult, HttpServletRequest request) {


        if (bindingResult.hasErrors()) {
            System.out.println("바인딩 에러");
            return "redirect:/";
        }

        User loginUser = userService.login(form);
        if (loginUser == null) {
            System.out.println("로그인 실패");
            return "redirect:/";
        }

        HttpSession session = request.getSession();

        session.setAttribute("LOGIN_USER", loginUser);
        System.out.println("세션에 보냄");
        return "redirect:/";

    }


}



