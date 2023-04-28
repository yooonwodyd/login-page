package mystudy.jaeyongmystudy.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Setter private String title;
    @Setter private String content;
    // @Setter private String author;
    @Setter @ManyToOne(optional = false) private User user;

    public Posts(Long postId, String title, String content, User user) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public static Posts of(Long postId, String title, String content, User user) {
        return new Posts(postId,title,content,user);
    }
}
