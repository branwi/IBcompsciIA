import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PracticeScene extends JPanel {
    IAframe frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton buttonHome = new JButton("Home");
    ArrayList<JButton> buttonTopics = new ArrayList<>();
    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String buttonText = e.getActionCommand();
                if(buttonText.equals("Home")){
                    frame.changeHome();
                    repaint();
                }
                if(buttonText.equals("<html>System of<br>Equations</html>")){
                    frame.changeProblem(1);
                    repaint();
                }
                if(buttonText.equals("Logarithms")){
                    frame.changeProblem(2);
                    repaint();
                }
                if(buttonText.equals("Polynomials")){
                    frame.changeProblem(3);
                    repaint();
                }
                if(buttonText.equals("Equations")){
                    frame.changeProblem(4);
                    repaint();
                }
                if(buttonText.equals("Trigonometry")){
                    frame.changeProblem(5);
                    repaint();
                }
                if(buttonText.equals("<html>Complex<br>Numbers</html>")){
                    frame.changeProblem(6);
                    repaint();
                }
                if(buttonText.equals("<html>Rational<br>Functions</html>")){
                    frame.changeProblem(7);
                    repaint();
                }
                if(buttonText.equals("Vectors")){
                    frame.changeProblem(8);
                    repaint();
                }
                if(buttonText.equals("<html>Probability and<br>Combinatorics</html>")){
                    frame.changeProblem(9);
                    repaint();
                }
                if(buttonText.equals("<html>Limits and<br>Continuity</html>")){
                    frame.changeProblem(10);
                    repaint();
                }
            }
        }
    }

    myListener listen = new myListener();
    public PracticeScene(IAframe frame){
        this.frame = frame;
        setLayout(null);
        drawTestScene();
        setButtons();
        setSize(screenSize);
    }
    public void drawTestScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonHome.setBounds((int) width *5 / 12, (int) height / 9, (int) width / 6,  (int) height / 9);
        buttonHome.addActionListener(listen);
        buttonHome.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        add(buttonHome);
    }
    public void setButtons(){
        buttonTopics.add(new JButton("<html>System of<br>Equations</html>"));
        buttonTopics.add(new JButton("Logarithms")); // No need for line break
        buttonTopics.add(new JButton("Polynomials")); // No need for line break
        buttonTopics.add(new JButton("Equations")); // No need for line break
        buttonTopics.add(new JButton("Trigonometry")); // No need for line break
        buttonTopics.add(new JButton("<html>Complex<br>Numbers</html>"));
        buttonTopics.add(new JButton("<html>Rational<br>Functions</html>"));
        buttonTopics.add(new JButton("Vectors")); // No need for line break
        buttonTopics.add(new JButton("<html>Probability and<br>Combinatorics</html>"));
        buttonTopics.add(new JButton("<html>Limits and<br>Continuity</html>"));

        for(int i = 0; i < 10; i++){
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            if(i < 5){
                buttonTopics.get(i).setBounds((int) width * (1 + 4 * i) /21, (int) height *5/9, (int) width / 7, (int) height / 9);
                buttonTopics.get(i).addActionListener(listen);
                buttonTopics.get(i).setFont(new Font("Arial", Font.PLAIN, (int) width/65));

                add(buttonTopics.get(i));
            }
            else{
                buttonTopics.get(i).setBounds((int) width * (1 + 4 * (i-5)) /21, (int) height *7/9, (int) width / 7, (int) height / 9);
                buttonTopics.get(i).addActionListener(listen);
                buttonTopics.get(i).setFont(new Font("Arial", Font.PLAIN, (int) width/65));

                add(buttonTopics.get(i));
            }

        }
    }
}
