package mystudy.jaeyongmystudy.service;

import mystudy.jaeyongmystudy.controller.posts.PostsForm;
import mystudy.jaeyongmystudy.entity.Posts;
import mystudy.jaeyongmystudy.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts createPosts(PostsForm postsForm){
        postsRepository.save(postsForm.toEntity());
        return postsForm.toEntity();
    }
    public List<Posts> postsList(){
        return postsRepository.findAll();
    }
}
