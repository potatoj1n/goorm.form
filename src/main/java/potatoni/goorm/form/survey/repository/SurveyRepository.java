package potatoni.goorm.form.survey.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import potatoni.goorm.form.survey.domain.Survey;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyRepository {
    private final EntityManager em;

    public void save(Survey survey){
        em.persist(survey);
    }

    //회원바탕 자신이 만든 설문조사 조회
    public List<Survey> findByMember(Long memberId){
        return em.createQuery("select s from Survey s where s.member.id = :memberId",Survey.class)
                .setParameter("memberId",memberId)
                .getResultList();
    }

    //설문조사 하나 조회
    public Survey findOne(Long id){
        return em.find(Survey.class, id);
    }

    //전체 설문조사 조회
    public List<Survey> findAll(){
        return em.createQuery("select s from Survey s",Survey.class).getResultList();
    }
}