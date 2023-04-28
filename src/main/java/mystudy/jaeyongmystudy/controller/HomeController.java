package mystudy.jaeyongmystudy.controller;

import mystudy.jaeyongmystudy.entity.User;
import mystudy.jaeyongmystudy.service.PostsService;
import mystudy.jaeyongmystudy.service.UserService;
import mystudy.jaeyongmystudy.service.kakao.KakaoLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    private final UserService userService;
    private final PostsService postsService;
    private final KakaoLoginService kakaoLoginService;

    @Autowired
    public HomeController(UserService userService, PostsService postsService, KakaoLoginService kakaoLoginService) {
        this.userService = userService;
        this.postsService = postsService;
        this.kakaoLoginService = kakaoLoginService;
    }

    @GetMapping("/")
    public String home(){

            return "home";
    }
    @GetMapping("/kakao")
    public String kakaoLogin(
            @RequestParam(value = "code", required = false) String code) throws Throwable{
        System.out.println("code:" + code);
        String access_Token = kakaoLoginService.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);


        return "home";
    }
    @GetMapping("logintest")
    public String login(){
        return "logintest";
    }
}
