import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PracticeScene extends JPanel {
    private IAframe frame;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton buttonHome = new JButton("Home");
    private ArrayList<JButton> buttonTopics = new ArrayList<>();

    public PracticeScene(IAframe frame){
        this.frame = frame;
        setLayout(null);
        drawPracticeScene();
        setSize(screenSize);
    }
    public void drawPracticeScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonHome.setBounds((int) width *5 / 12, (int) height / 9, (int) width / 6,  (int) height / 9);
        buttonHome.addActionListener(e -> frame.changeHome());
        buttonHome.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        add(buttonHome);

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

        for(int i = 0; i < 10; i++){
            JButton currentButton = buttonTopics.get(i);
            int finalI = i + 1;

            if(i < 5){
                currentButton.setBounds((int) width * (1 + 4 * i) /21, (int) height *5/9, (int) width / 7, (int) height / 9);
                currentButton.addActionListener(e -> frame.changeProblem(finalI));
                currentButton.setFont(new Font("Arial", Font.PLAIN, (int) width/65));
                add(currentButton);
            }
            else{
                currentButton.setBounds((int) width * (1 + 4 * (i-5)) /21, (int) height *7/9, (int) width / 7, (int) height / 9);
                currentButton.addActionListener(e -> frame.changeProblem(finalI));
                currentButton.setFont(new Font("Arial", Font.PLAIN, (int) width/65));
                add(currentButton);
            }
        }
    }
}