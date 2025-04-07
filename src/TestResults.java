public class TestResults {
    private int correct;
    private int incorrect;
    private int total;


    public TestResults(int correct, int incorrect, int total) {
        this.correct = correct;
        this.incorrect = incorrect;
        this.total = total;
    }

    public int getCorrect() { return correct; }
    public int getIncorrect() { return incorrect; }
    public int getTotal() { return total; }
    public double getPercentage() { return (correct * 100.0) / total; }
}
