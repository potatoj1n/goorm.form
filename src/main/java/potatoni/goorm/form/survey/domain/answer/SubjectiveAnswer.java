package potatoni.goorm.form.survey.domain.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import potatoni.goorm.form.survey.domain.Question;

@Entity
@Getter @Setter
public class SubjectiveAnswer {

    @Id @GeneratedValue
    @Column(name = "subjective_answer_id")
    private Long id;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

}
