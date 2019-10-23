import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Jag är en label");
    JPanel panel = new JPanel();

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b10 = new JButton("10");
    JButton b11 = new JButton("11");
    JButton b12= new JButton("12");
    JButton b13 = new JButton("13");
    JButton b14 = new JButton("14");
    JButton b15 = new JButton("15");
    JButton b16 = new JButton("16");
    JPanel p16 = new JPanel();



    public GameFrame(){
        p16.setBackground(Color.WHITE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(4);
        gridLayout.setRows(4);
        panel.setLayout(gridLayout);
        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4);
        panel.add(b5); panel.add(b6); panel.add(b7); panel.add(b8);
        panel.add(b9); panel.add(b10); panel.add(b11); panel.add(b12);
        panel.add(b13); panel.add(b14); panel.add(b15); panel.add(p16);
        b16.isVisible();
        add(panel);
        setSize(400, 400);
        this.setLocation(1000, 500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
