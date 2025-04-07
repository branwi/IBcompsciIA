import javax.swing.*;
import java.awt.*;

public class TestResultScene extends JPanel {
    public TestResultScene(IAframe frame, TestResults results) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));  // Light gray background

        // North panel with home button
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        homeButton.setPreferredSize(new Dimension(120, 40));
        homeButton.addActionListener(e -> frame.changeHome());
        northPanel.add(homeButton);
        northPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(northPanel, BorderLayout.NORTH);

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));

        // Title
        JLabel title = new JLabel("Test Results");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // Results panel
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultsPanel.setMaximumSize(new Dimension(400, 200));

        JLabel correctLabel = new JLabel("Correct Answers: " + results.getCorrect());
        correctLabel.setFont(new Font("Arial", Font.BOLD, 24));
        correctLabel.setForeground(new Color(0, 150, 0));  // Dark green

        JLabel incorrectLabel = new JLabel("Incorrect Answers: " + results.getIncorrect());
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 24));
        incorrectLabel.setForeground(new Color(150, 0, 0));  // Dark red

        JLabel scoreLabel = new JLabel("Final Score: " + String.format("%.1f", results.getPercentage()) + "%");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        scoreLabel.setForeground(new Color(0, 0, 150));  // Dark blue

        resultsPanel.add(correctLabel);
        resultsPanel.add(incorrectLabel);
        resultsPanel.add(scoreLabel);

        // Add components to content panel
        contentPanel.add(title);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(resultsPanel);

        // Add everything to main panel
        add(contentPanel, BorderLayout.CENTER);

        // Add some decorative elements
        contentPanel.setOpaque(false);
        resultsPanel.setOpaque(false);
    }
}