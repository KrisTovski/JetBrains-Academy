package engine.quiz;


import java.io.Serializable;
import java.util.Set;

public class Answer implements Serializable {
    private Set<Integer> answer;

    public Answer() {}

    public Set<Integer> getAnswer() {
        return answer;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "answer=" + answer +
                '}';
    }
}
