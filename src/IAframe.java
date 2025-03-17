import javax.swing.*;
import java.awt.*;

public class IAframe extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int state = 0;
    Homepage homepage = new Homepage();
    TestScene testScene = new TestScene();
    PracticeScene practiceScene = new PracticeScene();
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
}
