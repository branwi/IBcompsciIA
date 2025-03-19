import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProblemScene extends JPanel{
    IAframe frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String question;
    private double answer;
    private JTextField answerField;

    private JButton buttonHome = new JButton("Home");
    private JLabel problemLabel;

    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String buttonText = e.getActionCommand();
                if(buttonText.equals("Home")){
                    frame.changeHome();
                    repaint();
                }
                if(buttonText.equals("10 Questions")){
                    frame.changePractice();
                    repaint();
                }
                if(buttonText.equals("20 Questions")){
                    frame.changePractice();
                    repaint();
                }
                if(buttonText.equals("30 Questions")){
                    frame.changePractice();
                    repaint();
                }
            }
        }
    }
    myListener listen = new myListener();
    public ProblemScene(IAframe frame, String question, double answer){
        this.frame = frame;
        this.question = question;
        this.answer = answer;
        setLayout(null);
        drawProblemScene();
        setSize(screenSize);
    }

    public void drawProblemScene(){

        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        problemLabel = new JLabel(question, SwingConstants.CENTER);
        problemLabel.setFont(new Font("Arial", Font.PLAIN, (int) width/6));

        buttonHome.setBounds((int) width *5 / 12, (int) height / 9, (int) width / 6,  (int) height / 9);
        buttonHome.addActionListener(listen);
        buttonHome.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        answerField = new JTextField();
        answerField.setSize();

        add(buttonHome);
        add(buttonEasy);
        add(buttonMedium);
        add(buttonHard);
    }
}
