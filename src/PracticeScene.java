import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PracticeScene extends JPanel {
    private IAframe frame;
    private JButton buttonHome = new JButton("Home");
    private ArrayList<JButton> buttonTopics = new ArrayList<>();

    public PracticeScene(IAframe frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        drawPracticeScene();
    }

    public void drawPracticeScene() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonHome.addActionListener(e -> frame.changeHome());
        buttonHome.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(buttonHome);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 50, 20));

        JLabel instructionLabel = new JLabel("Choose a practice topic", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 40));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(instructionLabel);
        centerPanel.add(Box.createVerticalStrut(100));

        JPanel topicsPanel = new JPanel(new GridLayout(2, 5, 50, 50));

        buttonTopics.add(new JButton("<html>System of<br>Equations</html>"));
        buttonTopics.add(new JButton("Logarithms"));
        buttonTopics.add(new JButton("Polynomials"));
        buttonTopics.add(new JButton("Equations"));
        buttonTopics.add(new JButton("Trigonometry"));
        buttonTopics.add(new JButton("<html>Complex<br>Numbers</html>"));
        buttonTopics.add(new JButton("<html>Rational<br>Functions</html>"));
        buttonTopics.add(new JButton("Vectors"));
        buttonTopics.add(new JButton("<html>Probability and<br>Combinatorics</html>"));
        buttonTopics.add(new JButton("<html>Limits and<br>Continuity</html>"));

        for (int i = 0; i < buttonTopics.size(); i++) {
            JButton currentButton = buttonTopics.get(i);
            int finalI = i + 1;
            currentButton.addActionListener(e -> frame.changeProblem(finalI));
            currentButton.setFont(new Font("Arial", Font.PLAIN, 20));
            topicsPanel.add(currentButton);
        }

        centerPanel.add(topicsPanel);
        add(centerPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}