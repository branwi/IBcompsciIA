import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class IAframe extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private HomeScene homepage = new HomeScene(this);
    private TestScene testScene = new TestScene(this);
    private PracticeScene practiceScene = new PracticeScene(this);
    private ProblemScene problemScene;
    private ProblemDatabase problemDatabase;
    public IAframe(){
        try {
            problemDatabase = new ProblemDatabase();
            System.out.println("Problem database loaded successfully");
        } catch (Exception e) {
            System.err.println("Failed to load problem database: " + e.getMessage());
            // Initialize with empty database
            problemDatabase = new ProblemDatabase(new HashMap<>());
        }

        setSize(screenSize);
        add(homepage);
        setSize(screenSize);
        add(homepage);
    }
    public void changeTest(){
        remove(homepage);
        remove(practiceScene);
        add(testScene);
        revalidate();
        repaint();
    }
    public void changePractice(){
        remove(homepage);
        remove(testScene);
        add(practiceScene);
        revalidate();
        repaint();
    }
    public void changeProblem(int topic) {
        MathProblem randomProblem = problemDatabase.getRandomProblem(topic);
        if (randomProblem != null) {
            problemScene = new ProblemScene(this, randomProblem.getQuestion(), randomProblem.getAnswer(), topic);
            remove(homepage);
            remove(practiceScene);
            remove(testScene);
            add(problemScene);
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No problems available for this topic", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void changeHome(){
        remove(testScene);
        remove(practiceScene);
        remove(problemScene);
        add(homepage);
        revalidate();
        repaint();
    }
}
