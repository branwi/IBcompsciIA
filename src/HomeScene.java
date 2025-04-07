import javax.swing.*;
import java.awt.*;

public class HomeScene extends JPanel {
    private IAframe frame;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton buttonTest = new JButton("Test");
    private JButton buttonPractice = new JButton("Practice");
    public HomeScene(IAframe frame){
        this.frame = frame;
        setLayout(null);
        drawHomeScene();
        setSize(screenSize);
    }
    public void drawHomeScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonTest.setBounds((int) width *5 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonTest.addActionListener(e -> frame.changeTest());
        buttonTest.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        buttonPractice.setBounds((int) width *5 / 12, (int) height * 7 / 9, (int) width / 6,  (int) height / 9);
        buttonPractice.addActionListener(e -> frame.changePractice());
        buttonPractice.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        add(buttonTest);
        add(buttonPractice);
    }
}
