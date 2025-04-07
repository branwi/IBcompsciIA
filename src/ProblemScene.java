import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProblemScene extends JPanel {
    private IAframe frame;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String question;
    private String answer;
    private int topic;
    private JButton buttonHome = new JButton("Home");
    private boolean isTestMode = false;
    private TestSession testSession;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ProblemPanel problemPanel;
    private AnswerPanel answerPanel;

    public ProblemScene(IAframe frame, String question, String answer, int topic, boolean isTestMode) {
        this.frame = frame;
        this.question = question;
        this.answer = answer;
        this.topic = topic;
        this.isTestMode = isTestMode; // Set immediately
        setLayout(new BorderLayout()); // Add this line to set BorderLayout
        drawProblemScene();
    }

    public void setTestMode(boolean isTestMode, TestSession testSession) {
        this.isTestMode = isTestMode;
        this.testSession = testSession;
    }

    public void drawProblemScene() {
        removeAll();

        buttonHome.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(buttonHome);
        buttonHome.addActionListener(e -> frame.changeHome());
        add(northPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        problemPanel = new ProblemPanel();
        answerPanel = new AnswerPanel();

        mainPanel.add(problemPanel, "Problem");
        mainPanel.add(answerPanel, "Answer");

        cardLayout.show(mainPanel, "Problem");
        add(mainPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    class ProblemPanel extends JPanel {
        private JTextField answerField;

        public ProblemPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel problemLabel = new JLabel(question);
            problemLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            problemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            answerField = new JTextField(15);
            answerField.setMaximumSize(new Dimension(300, 40));
            answerField.setFont(new Font("Arial", Font.PLAIN, 20));
            answerField.setHorizontalAlignment(JTextField.CENTER);

            JButton buttonEnter = new JButton("Check Answer");
            buttonEnter.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonEnter.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonEnter.addActionListener(e -> checkAnswer());

            add(Box.createVerticalGlue());
            add(problemLabel);
            add(Box.createVerticalStrut(30));
            add(answerField);
            add(Box.createVerticalStrut(30));
            add(buttonEnter);
            add(Box.createVerticalGlue());
        }
        private boolean answersEqual(String userAnswer, String correctAnswer) {
            try {
                double userValue = Double.parseDouble(userAnswer);
                double correctValue = Double.parseDouble(correctAnswer);
                return Math.abs(userValue - correctValue) == 0;
            } catch (NumberFormatException e) {
                return userAnswer.equalsIgnoreCase(correctAnswer);
            }
        }
        private void checkAnswer() {
            String userAnswer = answerField.getText().trim().replaceAll("\\s+", "");
            boolean correct = answersEqual(userAnswer, answer);
            answerPanel.setResult(correct, String.valueOf(answer));
            cardLayout.show(mainPanel, "Answer");
        }
    }

    class AnswerPanel extends JPanel {
        private JLabel results = new JLabel();
        private JLabel progressLabel;
        private JLabel correctAnswerLabel = new JLabel();

        public AnswerPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            progressLabel = new JLabel();
            progressLabel.setFont(new Font("Arial",Font.BOLD,18));
            progressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            results.setFont(new Font("Arial", Font.BOLD, 24));
            results.setAlignmentX(Component.CENTER_ALIGNMENT);

            correctAnswerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            correctAnswerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton buttonBack = new JButton("Try Again");
            buttonBack.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonBack.addActionListener(e ->
                    cardLayout.show(mainPanel, "Problem")
            );

            JButton buttonNext = new JButton("Next Problem");
            buttonNext.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonNext.setAlignmentX(Component.CENTER_ALIGNMENT);

            if (isTestMode) {
                buttonNext.addActionListener(e -> {
                    if (!testSession.hasMoreProblems()) {
                        frame.showTestResults();
                    } else {
                        frame.showNextTestProblem();
                        System.out.println("Showing next problem!");
                    }
                });
            } else {
                buttonNext.addActionListener(e -> {
                    frame.changeProblem(topic);
                });
                System.out.println("Test mode:" + isTestMode);
            }

            add(Box.createVerticalGlue());
            add(results);
            add(progressLabel);
            add(Box.createVerticalStrut(20));
            add(correctAnswerLabel);
            add(Box.createVerticalStrut(40));
            add(buttonBack);
            add(Box.createVerticalStrut(60));
            add(buttonNext);
            add(Box.createVerticalGlue());
        }

        public void setResult(boolean isCorrect, String correctAnswer) {
            results.setText(isCorrect ? "Correct!" : "Incorrect!");
            results.setForeground(isCorrect ? Color.GREEN : Color.RED);
            correctAnswerLabel.setText("Correct answer: " + correctAnswer);
            if(isTestMode) {
                testSession.recordAnswer(isCorrect);
                progressLabel.setText(testSession.getProgress());
            }
        }
    }
}
