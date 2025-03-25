import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProblemScene extends JPanel {
    IAframe frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String question;
    private double answer;
    private JButton buttonHome = new JButton("Home");
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    class myListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonHome) {
                resetProblemScene();
                frame.getContentPane().removeAll();
                frame.changeHome();
                frame.revalidate();
                frame.repaint();
            }
        }
    }

    myListener listen = new myListener();
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ProblemPanel problemPanel;
    private AnswerPanel answerPanel;

    public ProblemScene(IAframe frame, String question, double answer) {
        this.frame = frame;
        this.question = question;
        this.answer = answer;
        setLayout(new BorderLayout());
        drawProblemScene();
        setSize(screenSize);
    }
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            resetProblemScene();
        }
    }

    private void resetProblemScene() {
        cardLayout.show(mainPanel, "Problem");
        problemPanel.reset();
        answerPanel.reset();
    }


    public void drawProblemScene() {
        removeAll();

        // Home button setup
        buttonHome.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(buttonHome);
        buttonHome.addActionListener(listen);
        add(northPanel, BorderLayout.NORTH);

        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        problemPanel = new ProblemPanel(this);
        answerPanel = new AnswerPanel(this);

        mainPanel.add(problemPanel, "Problem");
        mainPanel.add(answerPanel, "Answer");

        cardLayout.show(mainPanel, "Problem");
        add(mainPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    class ProblemPanel extends JPanel {
        private ProblemScene parent;
        private JTextField answerField;

        public ProblemPanel(ProblemScene parent) {
            this.parent = parent;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Problem label
            JLabel problemLabel = new JLabel(question);
            problemLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            problemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Answer field
            answerField = new JTextField(15);
            answerField.setMaximumSize(new Dimension(300, 40));
            answerField.setFont(new Font("Arial", Font.PLAIN, 20));
            answerField.setHorizontalAlignment(JTextField.CENTER);

            // Enter button
            JButton buttonEnter = new JButton("Check Answer");
            buttonEnter.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonEnter.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonEnter.addActionListener(e -> checkAnswer());

            // Add components with spacing
            add(Box.createVerticalGlue());
            add(problemLabel);
            add(Box.createVerticalStrut(30));
            add(answerField);
            add(Box.createVerticalStrut(30));
            add(buttonEnter);
            add(Box.createVerticalGlue());
        }

        private void checkAnswer() {
            String userAnswer = answerField.getText().trim();
            boolean correct = userAnswer.equals(String.valueOf(answer));
            parent.answerPanel.setResult(correct, String.valueOf(answer));
            parent.cardLayout.show(parent.mainPanel, "Answer");
        }
        public void reset() {
            answerField.setText("");
        }
    }

    class AnswerPanel extends JPanel {
        private JLabel results = new JLabel();
        private JLabel correctAnswerLabel = new JLabel();

        public AnswerPanel(ProblemScene parent) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Result label
            results.setFont(new Font("Arial", Font.BOLD, 24));
            results.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Correct answer label
            correctAnswerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            correctAnswerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Back button
            JButton buttonBack = new JButton("Try Again");
            buttonBack.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonBack.addActionListener(e ->
                    parent.cardLayout.show(parent.mainPanel, "Problem")
            );

            // Add components with spacing
            add(Box.createVerticalGlue());
            add(results);
            add(Box.createVerticalStrut(20));
            add(correctAnswerLabel);
            add(Box.createVerticalStrut(40));
            add(buttonBack);
            add(Box.createVerticalGlue());
        }

        public void setResult(boolean isCorrect, String correctAnswer) {
            results.setText(isCorrect ? "Correct!" : "Incorrect!");
            results.setForeground(isCorrect ? Color.GREEN : Color.RED);
            correctAnswerLabel.setText("Correct answer: " + correctAnswer);
        }
        public void reset() {
            results.setText("");
            correctAnswerLabel.setText("");
        }
    }

}