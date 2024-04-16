package potatoni.goorm.form.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String name;
    private String password;

    public MemberEntity(Long id, String loginId, String name, String password) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public MemberEntity() {
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
