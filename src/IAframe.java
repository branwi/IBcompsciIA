import javax.swing.*;
import java.awt.*;

public class IAframe extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int state = 0;
    HomeScene homepage = new HomeScene(this);
    TestScene testScene = new TestScene(this);
    PracticeScene practiceScene = new PracticeScene(this);
    public IAframe(){
        setSize(screenSize);
        add(homepage);
    }
    public void changeTest(){
        remove(homepage);
        add(testScene);
        revalidate();
        repaint();
    }
    public void changePractice(){
        remove(homepage);
        add(practiceScene);
        revalidate();
        repaint();
    }
    public void changeProblem(){

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
