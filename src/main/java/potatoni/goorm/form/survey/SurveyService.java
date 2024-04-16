package potatoni.goorm.form.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import potatoni.goorm.form.member.MemberEntity;
import potatoni.goorm.form.member.MemberRepository;
import potatoni.goorm.form.survey.domain.Question;
import potatoni.goorm.form.survey.domain.Survey;
import potatoni.goorm.form.survey.domain.Vote;
import potatoni.goorm.form.survey.repository.QuestionRepository;
import potatoni.goorm.form.survey.repository.SurveyRepository;
import potatoni.goorm.form.survey.repository.VoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final VoteRepository voteRepository;

    //  private final ObjectiveAnswerRepository objectiveAnswerRepository;
    //  private final SubjectiveAnswer subjectiveAnswer;

    //설문 생성   Member member, String title
    @Transactional
    public Long makeSurvey(Long memberId, String title, List<Question> questionList){

        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("No member found with ID: " + memberId));
        Survey survey = Survey.createSurvey(memberEntity,title);

        surveyRepository.save(survey);

        for(Question q : questionList){
            q.setSurvey(survey);
            questionRepository.save(q);
        }

        return survey.getId();
    }

    //설문목록 전체 조회
    public List<Survey> findSurveys(){
        return surveyRepository.findAll();
    }

    //자신이 생성한 설문목록 조회
    public List<Survey> findSurveyByMake(Long memberId){
        return surveyRepository.findByMember(memberId);
    }

    //자신이 투표한 설문목록 조회
    public List<Survey> findSurveyByVote(Long memberId){
        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("No member found with ID: " + memberId));
        List<Vote> votes = voteRepository.findByMember(memberEntity);

        List<Survey> results = new ArrayList<>();

        for(Vote v : votes){
            results.add(v.getSurvey());
        }

        return results;
    }

    //설문투표
//    public Survey voteSurvey(){
//
//    }



}

