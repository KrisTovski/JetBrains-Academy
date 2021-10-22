package engine.quiz;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuizService {

    public List<Quiz> getAllQuizzes();

    public Quiz getQuizById(@PathVariable long id);

    public Quiz createQuiz(@RequestBody Quiz newQuiz);

    public AnswerFeedback solve(@PathVariable long id, @RequestBody Answer answer);

    public void deleteQuiz(long id);
}
