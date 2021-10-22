package engine.quiz;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class AnswerFeedback {
    private final boolean success;
    private final String feedback;
    private final String correct = "Congratulations, you're right!";
    private final String wrong = "Wrong answer! Please, try again.";


    public AnswerFeedback(boolean success) {
        this.success = success;
        this.feedback = success ? correct : wrong;
    }


    public boolean getSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}
