package potatoni.goorm.form.survey.domain.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import potatoni.goorm.form.survey.domain.Question;

@Entity
@Getter @Setter
public class ObjectiveAnswer {

    @Id @GeneratedValue
    @Column(name = "objective_answer_id")
    private Long id;

    private String answer;

    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
