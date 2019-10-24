import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class GameFrame extends JFrame implements ActionListener {

    int SIZE = 4;
    int SQUARESIZE = SIZE * SIZE;
    private JButton[][] board = new JButton[SIZE][SIZE];
    private JPanel panel = new JPanel();

    public void initiateBoard() {
        // The list is used for create a shuffled order of 1-16
        ArrayList<Integer> intialList = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SQUARESIZE; i++) {
            intialList.add(i, i); // i, i is for index and value
        }
        // make the shuffle
        Collections.shuffle(intialList);

        // place JButtons in the board array with shuffled text(0-16) on them
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new JButton(intialList.get(counter).toString());

                counter++;
            }
        }
    }

    public GameFrame() {
        initiateBoard();
        setTitle("Fifteen Puzzle Game");
        setSize(400, 400);
        setResizable(false);
        panel.setLayout(new GridLayout(4, 4));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                panel.add(board[i][j]);
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setVisible(false);
                }
                board[i][j].addActionListener(this);
                board[i][j].addMouseListener(m1);
            }
        }
        add(panel);

    }

    public static void main(String[] args) {
        new GameFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
    MouseAdapter m1 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            JButton tempButton = (JButton) e.getComponent();
            System.out.println(tempButton.getText().toString());


        }
    };
}
