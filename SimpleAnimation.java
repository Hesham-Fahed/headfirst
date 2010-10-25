import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 20;
    int y = 20;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i = 0; i < 130; i++) {
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(50);
            } catch(Exception ex) {
                System.out.println("Thread.sleep Exception");
                ex.printStackTrace();
            }
        }
    }
    
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(x,y,100,100);
        }
    }
}
