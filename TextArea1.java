import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 {
    JTextArea textArea;

    public static void main(String[] args) {
        TextArea1 ta = new TextArea1();
        ta.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just Click It");
        button.addActionListener(new buttonListener());
        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.setSize(350,300);
        frame.setVisible(true);
    }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textArea.append("button clicked \n");
        }
    }
}
