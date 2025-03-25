public class MathProblem {
    private String question;
    private double answer;
    private int topic; // Could use an enum here instead

    public MathProblem(String question, double answer, int topic) {
        this.question = question;
        this.answer = answer;
        this.topic = topic;
    }

    // Getters
    public String getQuestion() { return question; }
    public double getAnswer() { return answer; }
    public int getTopic() { return topic; }
}