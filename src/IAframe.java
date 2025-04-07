import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class IAframe extends JFrame {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private HomeScene homepage = new HomeScene(this);
    private TestScene testScene = new TestScene(this);
    private PracticeScene practiceScene = new PracticeScene(this);
    private ProblemScene problemScene;
    private ProblemDatabase problemDatabase;
    private TestSession currentTest;
    private TestResultScene resultScene;

    public IAframe() throws IOException {
        problemDatabase = new ProblemDatabase();
        setSize(screenSize);
        add(homepage);
    }
    public void changeTest() {
        removeAllPanels();  // This now removes all possible panels
        add(testScene);
        revalidate();
        repaint();
    }
    public void changePractice(){
        removeAllPanels();
        add(practiceScene);
        revalidate();
        repaint();
    }
    public void changeProblem(int topic) {
        if (problemScene != null) {
            remove(problemScene);
            problemScene = null;
        }
        if(currentTest != null && currentTest.hasMoreProblems()) {
            showNextTestProblem();
        } else {
            MathProblem randomProblem = problemDatabase.getRandomProblem(topic);
            problemScene = new ProblemScene(this, randomProblem.getQuestion(), randomProblem.getAnswer(), topic, false);
            remove(homepage);
            remove(practiceScene);
            remove(testScene);
            add(problemScene);
            revalidate();
            repaint();
        }
    }
    public void changeHome() {
        removeAllPanels();  // This now removes all possible panels
        add(homepage);
        revalidate();
        repaint();
    }
    public void startTest(ArrayList<MathProblem> problems) {
        currentTest = new TestSession(problems);
        showNextTestProblem();
    }
    public void showNextTestProblem() {
        if (currentTest == null || !currentTest.hasMoreProblems()) {
            showTestResults();
            System.out.println("Test Results shown!");
            return;
        }
        removeAllPanels();
        MathProblem problem = currentTest.getNextProblem();
        if (problem == null) {
            showTestResults();
            return;
        }
        problemScene = new ProblemScene(this, problem.getQuestion(), problem.getAnswer(), problem.getTopic(), true);
        problemScene.setTestMode(true, currentTest);
        add(problemScene);
        revalidate();
        repaint();
    }


    public void showTestResults() {
        TestResults results = currentTest.getResults();
        resultScene = new TestResultScene(this, results);
        removeAllPanels();
        add(resultScene);
        revalidate();
        repaint();
        currentTest = null; // Clear the test session
    }

    private void removeAllPanels() {
        remove(homepage);
        remove(testScene);
        remove(practiceScene);
        if (resultScene != null ){
            remove(resultScene);
        }
        if (problemScene != null) {
            remove(problemScene);
            problemScene = null;
        }
    }
}
