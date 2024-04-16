package potatoni.goorm.form.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import potatoni.goorm.form.survey.domain.Survey;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/survey")
    public List<Survey> getAllPolling(){
        return surveyService.findSurveys();
    }
}
