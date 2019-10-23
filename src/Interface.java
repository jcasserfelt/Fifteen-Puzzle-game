import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Interface extends JFrame /*implements ActionListener*/ {

    JPanel panel = new JPanel();
    //private static final String[] BUTTONVALUE = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
    JButton[] button = new JButton[15];


    Interface() {
        //FRAME
        //todo add title
        setSize(400, 400);
        setResizable(false);
        panel.setLayout(new GridLayout(4, 4));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel);
        //PANEL
        for (int i = 0; i < 15; i++) {
            this.button[i] = new JButton("" + (i + 1)); //annars BUTTONVALUE[i]
            this.button[i].setHorizontalAlignment(JLabel.CENTER);
            this.button[i].setOpaque(true);
            this.button[i].setFont(new Font("serif", 1, 32));
            this.button[i].setForeground(Color.WHITE);
            this.button[i].setBackground(Color.DARK_GRAY);
            this.button[i].setBorder(new LineBorder(Color.RED, 2));
            panel.add(this.button[i]);
        }





    }

}