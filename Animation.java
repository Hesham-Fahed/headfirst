import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Animation {
    JFrame frame;
    int x = 0;
    int y = 0;
    
    public static void main(String[] args)  {
        Animation ani = new Animation();
            ani.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton startButton = new JButton("Start Animation!");
        startButton.addActionListener(new AnimationListener());

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, startButton);

        frame.setSize(600,600);
        frame.setVisible(true);
    }

    class AnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
            x += 10;
            y += 10;
        }
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
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
