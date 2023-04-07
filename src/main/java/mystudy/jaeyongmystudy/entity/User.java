package mystudy.jaeyongmystudy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    private String password;

    private String rank;

    @Builder
    public User(String name, String rank, String password) {
        this.name = name;
        this.rank = rank;
        this.password = password;
    }
}
