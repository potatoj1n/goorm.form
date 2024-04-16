package potatoni.goorm.form.survey.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import potatoni.goorm.form.member.MemberEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes = new ArrayList<>();

    private LocalDateTime startDate;
    private String title;

    public void addVote(Vote vote){
        votes.add(vote);
        vote.setSurvey(this);
    }

    // 설문조사 생성 메서드, MemberEntity를 인자로 받아 처리
    public static Survey createSurvey(MemberEntity member, String title) {
        Survey survey = new Survey();
        survey.setMember(member);
        survey.setStartDate(LocalDateTime.now());
        survey.setTitle(title);
        return survey;
    }
}
