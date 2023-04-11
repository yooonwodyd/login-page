package mystudy.jaeyongmystudy.controller.posts;

import lombok.Getter;
import lombok.Setter;
import mystudy.jaeyongmystudy.entity.Posts;
import mystudy.jaeyongmystudy.entity.User;

@Getter
@Setter
public class PostsForm {
    public Long postId;
    public String title;
    public String content;
    public String author;

    public Posts toEntity() {
        return Posts.builder()
                .postId(this.postId)
                .content(this.content)
                .author(this.author)
                .title(this.title)
                .build();
    }

}
