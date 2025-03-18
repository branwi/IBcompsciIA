import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestScene extends JPanel {
    IAframe frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String buttonText = e.getActionCommand();
                if(buttonText.equals("Home")){
                    frame.changeHome();
                    repaint();
                }
                if(buttonText.equals("Practice")){
                    frame.changePractice();
                    repaint();
                }
            }
        }
    }
    private JButton buttonHome = new JButton("Home");
    private JButton buttonEasy = new JButton("10 Questions");
    private JButton buttonMedium = new JButton("20 Questions");
    private JButton buttonHard = new JButton("30 Questions");

    myListener listen = new myListener();
    public TestScene(IAframe frame){
        this.frame = frame;
        setLayout(null);
        drawTestScene();
        setSize(screenSize);
    }
    public void drawTestScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonHome.setBounds((int) width *5 / 12, (int) height / 9, (int) width / 6,  (int) height / 9);
        buttonHome.addActionListener(listen);
        buttonHome.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        buttonEasy.setBounds((int) width *2 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonEasy.addActionListener(listen);
        buttonEasy.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        buttonMedium.setBounds((int) width *5 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonMedium.addActionListener(listen);
        buttonMedium.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        buttonHard.setBounds((int) width *8 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 3);
        buttonHard.addActionListener(listen);
        buttonHard.setFont(new Font("Arial", Font.PLAIN, (int) width/65));
        add(buttonHome);
        add(buttonEasy);
        add(buttonMedium);
        add(buttonHard);
    }
}
