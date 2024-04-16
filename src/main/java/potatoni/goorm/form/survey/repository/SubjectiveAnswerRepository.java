package potatoni.goorm.form.survey.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import potatoni.goorm.form.survey.domain.Question;
import potatoni.goorm.form.survey.domain.answer.SubjectiveAnswer;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectiveAnswerRepository {

    private final EntityManager em;

    public void save(SubjectiveAnswer subjectiveAnswer){
        em.persist(subjectiveAnswer);
    }

    //특정 질문에 대한 대답들 반환
    public List<SubjectiveAnswer> findByQuestion(Question question){
        return em.createQuery("select s from SubjectiveAnswer s where s.question = :question ",SubjectiveAnswer.class)
                .setParameter("question",question)
                .getResultList();
    }
}
