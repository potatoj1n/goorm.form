package potatoni.goorm.form.survey.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import potatoni.goorm.form.member.MemberDto;

@Entity
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "vote_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberDto member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;
}
