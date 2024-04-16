package potatoni.goorm.form.survey.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import potatoni.goorm.form.survey.domain.Question;
import potatoni.goorm.form.survey.domain.answer.ObjectiveAnswer;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ObjectiveAnswerRepository {

    private final EntityManager em;

    public void save(ObjectiveAnswer objectiveAnswer){
        if(objectiveAnswer.getId()==null) {
            em.persist(objectiveAnswer);
        }else{
            em.merge(objectiveAnswer);
        }
    }

    //특정 질문에 대한 대답들 반환
    public List<ObjectiveAnswer> findByQuestion(Question question){
        return em.createQuery("select o from ObjectiveAnswer o where o.question = :question ",ObjectiveAnswer.class)
                .setParameter("question",question)
                .getResultList();
    }
}
