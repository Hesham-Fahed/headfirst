import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextField {
    JFrame frame;
    JTextField textField;

    public static void main(String[] args) {
        TextField tf = new TextField();
        tf.go();
    }

    public void go() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.darkGray);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.darkGray);

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        textField = new JTextField(20);
        textField.setText("write your name");
        textField.selectAll();
        panel2.add(textField);

        JButton sendButton = new JButton("SEND");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        sendButton.setFont(bigFont);
        sendButton.addActionListener(new buttonListener());
        panel.add(sendButton);
        
        JButton okButton = new JButton("OK");
        JButton noButton = new JButton("NO");
        okButton.addActionListener(new okButtonListener());
        noButton.addActionListener(new noButtonListener());
        panel3.add(okButton);
        panel3.add(noButton);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.getContentPane().add(BorderLayout.NORTH,panel2);
        frame.getContentPane().add(BorderLayout.EAST,panel3);
        frame.setSize(600,300);
        frame.setVisible(true);
    }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println(textField.getText());
            textField.requestFocus();
        }
    }
    class okButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textField.setText("OK");
            System.out.println(textField.getText());
            textField.requestFocus();
        }
    }
    class noButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textField.setText("NO");
            System.out.println(textField.getText());
            textField.requestFocus();
        }
    }
}
