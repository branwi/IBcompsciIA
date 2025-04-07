import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class TestScene extends JPanel {
    private IAframe frame;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ProblemDatabase problemDatabase;

    public TestScene(IAframe frame) throws IOException {
        this.frame = frame;
        this.problemDatabase = new ProblemDatabase();
        setLayout(null);
        drawTestScene();
        setSize(screenSize);
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

    private JButton buttonHome = new JButton("Home");
    private JButton buttonShort = new JButton("10 Questions");
    private JButton buttonMedium = new JButton("20 Questions");
    private JButton buttonLong = new JButton("30 Questions");

    public void drawTestScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonHome.setBounds((int) width *5 / 12, (int) height / 9, (int) width / 6,  (int) height / 9);
        buttonHome.addActionListener(e -> frame.changeHome());
        buttonHome.setFont(new Font("Arial", Font.PLAIN, (int) width/65));


        buttonShort.setBounds((int) width *2 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonShort.addActionListener(e -> testStart(10));
        buttonShort.setFont(new Font("Arial", Font.PLAIN, (int) width/65));


        buttonMedium.setBounds((int) width *5 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonMedium.addActionListener(e -> testStart(20));
        buttonMedium.setFont(new Font("Arial", Font.PLAIN, (int) width/65));


        buttonLong.setBounds((int) width *8 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonLong.addActionListener(e -> testStart(30));
        buttonLong.setFont(new Font("Arial", Font.PLAIN, (int) width/65));
        add(buttonHome);
        add(buttonShort);
        add(buttonMedium);
        add(buttonLong);
    }
}
