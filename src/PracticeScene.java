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
                if(buttonText.equals("Practice")){
                    frame.changePractice();
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
        buttonTopics.add(new JButton("Topic 1"));
        buttonTopics.add(new JButton("Topic 2"));
        buttonTopics.add(new JButton("Topic 3"));
        buttonTopics.add(new JButton("Topic 4"));
        buttonTopics.add(new JButton("Topic 5"));
        buttonTopics.add(new JButton("Topic 6"));
        buttonTopics.add(new JButton("Topic 7"));
        buttonTopics.add(new JButton("Topic 8"));
        buttonTopics.add(new JButton("Topic 9"));
        buttonTopics.add(new JButton("Topic 10"));

        for(int i = 0; i < 10; i++){
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            if(i < 5){
                buttonTopics.get(i).setBounds((int) width * (1 + 4 * i) /21, (int) height *3/9, (int) width / 7, (int) height / 9);
                buttonTopics.get(i).addActionListener(listen);
                buttonTopics.get(i).setFont(new Font("Arial", Font.PLAIN, (int) width/65));

                add(buttonTopics.get(i));
            }
            else{
                buttonTopics.get(i).setBounds((int) width * (1 + 4 * (i-5)) /21, (int) height *6/9, (int) width / 7, (int) height / 9);
                buttonTopics.get(i).addActionListener(listen);
                buttonTopics.get(i).setFont(new Font("Arial", Font.PLAIN, (int) width/65));

                add(buttonTopics.get(i));
            }

        }
    }
}
