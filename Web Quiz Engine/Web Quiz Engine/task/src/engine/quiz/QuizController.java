package engine.quiz;

import engine.QuizNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/quizzes")
public class QuizController {

    private final QuizService quizService;

    private static final String QUIZ_NOT_FOUND = "Quiz not found";

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) throw new QuizNotFoundException(QUIZ_NOT_FOUND);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody @Valid Quiz newQuiz) {

        Quiz quizCreated = quizService.createQuiz(newQuiz);
        return new ResponseEntity<>(quizCreated, HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/solve")
    public ResponseEntity<AnswerFeedback> solve(@PathVariable long id, @RequestBody Answer answer) {
        AnswerFeedback answerChecked = quizService.solve(id, answer);

        return new ResponseEntity<>(answerChecked, HttpStatus.OK);
    }


    @DeleteMapping(path = "/api/quizzes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable final long id) {
        quizService.deleteQuiz(id);
    }


}
