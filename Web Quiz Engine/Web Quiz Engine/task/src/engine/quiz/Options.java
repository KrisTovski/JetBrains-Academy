package engine.quiz;

public class Options {

    private int[] answer;

    public Options() {}

    public Options(int[] options) {
        this.answer = options.clone();
    }

    public int[] getAnswer() {
        return this.answer.clone();
    }
    public void setAnswer(int[] options) {
        this.answer = options.clone();
    }
}
