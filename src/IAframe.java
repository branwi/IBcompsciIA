import javax.swing.*;
import java.awt.*;

public class IAframe extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private HomeScene homepage = new HomeScene(this);
    private TestScene testScene = new TestScene(this);
    private PracticeScene practiceScene = new PracticeScene(this);
    private ProblemScene problemScene;
    public IAframe(){
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
    public void changeProblem(int topic){
        if(topic == 1){
            problemScene = new ProblemScene(this, "System of Equations", 1.0);
        }
        if(topic == 2){
            problemScene = new ProblemScene(this, "Logarithms", 1.0);
        }
        if(topic == 3){
            problemScene = new ProblemScene(this, "Polynomials", 1.0);
        }
        if(topic == 4){
            problemScene = new ProblemScene(this, "Equations", 1.0);
        }
        if(topic == 5){
            problemScene = new ProblemScene(this, "Trigonometry", 1.0);
        }
        if(topic == 6){
            problemScene = new ProblemScene(this, "Complex Numbers", 1.0);
        }
        if(topic == 7){
            problemScene = new ProblemScene(this, "Rational Functions", 1.0);
        }
        if(topic == 8){
            problemScene = new ProblemScene(this, "Vectors", 1.0);
        }
        if(topic == 9){
            problemScene = new ProblemScene(this, "Probability and Combinatorics", 1.0);
        }
        if(topic == 10){
            problemScene = new ProblemScene(this, "Limits and Continuity", 1.0);
        }
        remove(practiceScene);
        remove(testScene);
        add(problemScene);
        revalidate();
        repaint();
    }
    public void changeAnswer(){

    }
    public void changeHome(){
        remove(testScene);
        remove(practiceScene);
        add(homepage);
        revalidate();
        repaint();
    }
}
