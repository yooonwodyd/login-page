package mystudy.jaeyongmystudy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    private String password;

    private String user_rank;

    @Builder
    public User(Long userId, String name, String user_rank, String password) {
        this.userId = userId;
        this.name = name;
        this.user_rank = user_rank;
        this.password = password;
    }
}
