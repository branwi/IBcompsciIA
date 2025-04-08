import java.util.ArrayList;


public class TestSession {
    private ArrayList<MathProblem> problems;
    private int currentIndex = 0;
    private int correct = 0;
    private int incorrect = 0;

    public TestSession(ArrayList<MathProblem> problems) {
        this.problems = new ArrayList<>(problems);
    }

    public boolean hasMoreProblems() {
        return currentIndex < problems.size();
    }

    public MathProblem getNextProblem() {
        if (!hasMoreProblems()) {
            return null;
        }
        MathProblem problem = problems.get(currentIndex);
        currentIndex++;
        System.out.println("Current Index: " + currentIndex);
        return problem;
    }

    public void recordAnswer(boolean isCorrect) {
        if (isCorrect) correct++;
        else incorrect++;
    }


    public TestResults getResults() {
        return new TestResults(correct, incorrect, problems.size());
    }


    public String getProgress() {
        return String.format("%d/%d Correct", correct, currentIndex);
    }
}
