import javax.swing.*;
import java.awt.*;

public class TestResultScene extends JPanel {
    private IAframe frame;
    private TestResults results;
    private JButton buttonHome = new JButton("Home");

    public TestResultScene(IAframe frame, TestResults results) {
        this.frame = frame;
        this.results = results;
        setLayout(new BorderLayout());
        drawTestResultScene();
    }

    public void drawTestResultScene(){
        buttonHome.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(buttonHome);
        buttonHome.addActionListener(e -> frame.changeHome());
        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));

        JLabel title = new JLabel("Test Results");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        centerPanel.add(title);

        JLabel correctLabel = new JLabel("Correct Answers: " + results.getCorrect());
        correctLabel.setFont(new Font("Arial", Font.BOLD, 24));
        correctLabel.setForeground(new Color(0, 150, 0));
        correctLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(correctLabel);
        centerPanel.add(Box.createVerticalStrut(10));

        JLabel incorrectLabel = new JLabel("Incorrect Answers: " + results.getIncorrect());
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 24));
        incorrectLabel.setForeground(new Color(150, 0, 0));
        incorrectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(incorrectLabel);
        centerPanel.add(Box.createVerticalStrut(10));

        JLabel scoreLabel = new JLabel("Final Score: " + String.format("%.1f", results.getPercentage()) + "%");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        scoreLabel.setForeground(new Color(0, 0, 150));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(scoreLabel);

        add(centerPanel, BorderLayout.CENTER);

        centerPanel.setOpaque(false);
    }
}