public class MathProblem {
    private String question;
    private String answer;
    private int topic; // Could use an enum here instead

    public MathProblem(String question, String answer, int topic) {
        this.question = question;
        this.answer = answer;
        this.topic = topic;
    }

    // Getters
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public int getTopic() { return topic; }
}