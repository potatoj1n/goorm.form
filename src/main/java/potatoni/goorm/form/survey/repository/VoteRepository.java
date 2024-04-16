package potatoni.goorm.form.survey.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import potatoni.goorm.form.member.MemberEntity;
import potatoni.goorm.form.survey.domain.Vote;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VoteRepository {

    private final EntityManager em;

    //vote 관계 테이블 저장
    public void save(Vote vote){
        em.persist(vote);
    }

    //특정 회원을 바탕으로 투표한 vote 정보 반환
    public List<Vote> findByMember(MemberEntity member){
        return em.createQuery("select v from Vote v where v.member = :member ",Vote.class)
                .setParameter("member",member)
                .getResultList();
    }
}
