package mystudy.jaeyongmystudy.controller.posts;

import mystudy.jaeyongmystudy.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PostsController {
    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/posts/register")
    public String postsRegister(PostsForm postsForm){
        postsService.createPosts(postsForm);
        return "redirect:/";
    }
}
