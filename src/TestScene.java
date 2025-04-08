import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TestScene extends JPanel {
    private IAframe frame;
    private ProblemDatabase problemDatabase;
    private JButton buttonHome = new JButton("Home");
    private JButton buttonShort = new JButton("10 Questions");
    private JButton buttonMedium = new JButton("20 Questions");
    private JButton buttonLong = new JButton("30 Questions");

    public TestScene(IAframe frame) throws IOException {
        this.frame = frame;
        this.problemDatabase = new ProblemDatabase();
        setLayout(new BorderLayout());
        drawTestScene();
    }

    private void testStart(int questionCount) {
        ArrayList<MathProblem> testProblems = new ArrayList<>();
        int questionsPerTopic = questionCount / 10;
        for (int topic = 1; topic <= 10; topic++) {
            for (int i = 0; i < questionsPerTopic; i++) {
                MathProblem problem = problemDatabase.getRandomProblem(topic);
                testProblems.add(problem);
            }
        }
        if (testProblems.size() == questionCount) {
            frame.startTest(testProblems);
        }
    }

    public void drawTestScene(){
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonHome.addActionListener(e -> frame.changeHome());
        buttonHome.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(buttonHome);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 200, 100));

        JLabel instructionLabel = new JLabel("Choose a test length", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 40));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(instructionLabel);
        centerPanel.add(Box.createVerticalStrut(100));

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 100, 20));
        buttonShort.addActionListener(e -> testStart(10));
        buttonShort.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonsPanel.add(buttonShort);

        buttonMedium.addActionListener(e -> testStart(20));
        buttonMedium.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonsPanel.add(buttonMedium);

        buttonLong.addActionListener(e -> testStart(30));
        buttonLong.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonsPanel.add(buttonLong);

        centerPanel.add(buttonsPanel);
        add(centerPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}