package engine.quiz;

import engine.QuizNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static engine.security.SecurityConfig.getCurrentUser;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz Not found"));

    }

    @Override
    public Quiz createQuiz(Quiz newQuiz) {
        return quizRepository.save(newQuiz);
    }

    @Override
    public AnswerFeedback solve(long id, Answer answer) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new QuizNotFoundException("Quiz Not found"));
        if(quiz.isCorrect(answer.getAnswer())){
            return new AnswerFeedback(true);
        } else {
            return new AnswerFeedback(false);
        }

      // return answer.containsAll(quiz) && quiz.containsAll(answer) ? new AnswerFeedback(true) : new AnswerFeedback(false);


    }

    @Override
    public void deleteQuiz(long id) {
        if (!getCurrentUser().getEmail().equals(getQuizById(id).getAuthor().getEmail()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not the author of this quiz.");
        quizRepository.deleteById(id);

    }
}

