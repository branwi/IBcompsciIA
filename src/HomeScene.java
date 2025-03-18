import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScene extends JPanel {
    IAframe frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String buttonText = e.getActionCommand();
                if(buttonText.equals("Test")){
                    frame.changeTest();
                    System.out.println("Changed to Test!");
                    repaint();
                }
                if(buttonText.equals("Practice")){
                    frame.changePractice();
                    System.out.println("Changed to Practice!");
                    repaint();
                }
            }
        }
    }
    private JButton buttonTest = new JButton("Test");
    private JButton buttonPractice = new JButton("Practice");

    myListener listen = new myListener();
    public HomeScene(IAframe frame){
        this.frame = frame;
        setLayout(null);
        drawHomeScene();
        setSize(screenSize);
    }
    public void drawHomeScene(){
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        buttonTest.setBounds((int) width *5 / 12, (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonTest.addActionListener(listen);
        buttonTest.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        buttonPractice.setBounds((int) width *5 / 12, (int) height * 7 / 9, (int) width / 6,  (int) height / 9);
        buttonPractice.addActionListener(listen);
        buttonPractice.setFont(new Font("Arial", Font.PLAIN, (int) width/65));

        add(buttonTest);
        add(buttonPractice);
    }
}
