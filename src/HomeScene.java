import javax.swing.*;
import java.awt.*;

public class HomeScene extends JPanel {
    private IAframe frame;
    private JButton buttonTest = new JButton("Test");
    private JButton buttonPractice = new JButton("Practice");

    public HomeScene(IAframe frame){
        this.frame = frame;
        setLayout(new BorderLayout());
        drawHomeScene();
    }

    public void drawHomeScene(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(Box.createVerticalStrut(200));
        JLabel label = new JLabel("Welcome to the Math Practice Application");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(label);
        centerPanel.add(Box.createVerticalStrut(100));

        buttonTest.addActionListener(e -> frame.changeTest());
        buttonTest.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonTest.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(buttonTest);
        centerPanel.add(Box.createVerticalStrut(100));

        buttonPractice.addActionListener(e -> frame.changePractice());
        buttonPractice.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPractice.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(buttonPractice);

        add(centerPanel, BorderLayout.CENTER);
        add(Box.createHorizontalStrut(50), BorderLayout.WEST);
        add(Box.createHorizontalStrut(50), BorderLayout.EAST);
    }
}