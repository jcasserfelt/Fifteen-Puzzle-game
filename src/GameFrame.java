import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;


public class GameFrame extends JFrame implements ActionListener {

    //KLASSVARIABLER
    static int SIZE = 4;
    static int SQUARESIZE = SIZE * SIZE;
    static JButton[][] board = new JButton[SIZE][SIZE];
    static JPanel boardPanel = new JPanel();


    //INSTANSVARIABLER
    private ImageIcon git1 = new ImageIcon("src\\east1.jpg");
    private ImageIcon git2 = new ImageIcon("src\\west1.jpg");
    private JLabel east = new JLabel();
    private JLabel west = new JLabel();
    private JButton newGame = new JButton("NEW GAME");
    private JButton fusk = new JButton ("f");
    private JPanel newGamePanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel northPanel = new JPanel();

    //-------------------------------------------------------------------------------------------------
    //COSTRUCTOR
    public GameFrame() {
        initiateBoard();
        manageLayout();
        addButtons();
        //väntefas: programmet går vidare från MouseEvents
    }

    //-------------------------------------------------------------------------------------------------
    //INSTANSMETODER
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


    public void manageLayout() {
        setTitle("Fifteen Puzzle Game");
        setSize(540,440);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        boardPanel.setLayout(new GridLayout(SIZE, SIZE));
        add(boardPanel, BorderLayout.CENTER );
        add(newGamePanel, BorderLayout.SOUTH );
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(northPanel, BorderLayout.NORTH);
        eastPanel.setBackground(Color.black);
        westPanel.setBackground(Color.black);
        northPanel.setBackground(Color.black);
        boardPanel.setBackground(Color.black);
        newGamePanel.setBackground(Color.black);
        east.setIcon(git1);
        west.setIcon((git2));
        eastPanel.add(east);
        westPanel.add(west);
    }


    private void addButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardPanel.add(board[i][j]);
                hideZero(board, i, j);
                board[i][j].addMouseListener(m1);
            }
        }

        newGamePanel.add(newGame).setPreferredSize(new Dimension(130,30));
        newGamePanel.add(fusk).setPreferredSize(new Dimension(40,30));
        newGame.addMouseListener(m2);
        fusk.addActionListener(this);
    }


    private void hideZero (JButton board[][], int i, int j){
        if (board[i][j].getText().equals("0")) {
            board[i][j].setVisible(false);
        } else {
            board[i][j].setVisible(true);
        }
    }
    //-------------------------------------------------------------------------------------------------
    //EVENTS

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fusk) {
            if (Check.fuskMode == false) {
                Check.fuskMode = true;
                fusk.setBackground(Color.RED);
            }
           else {
                Check.fuskMode = false;
                fusk.setBackground(new JButton().getBackground());
            }

        }
    }
    MouseAdapter m1 = new MouseAdapter() {                  //MOVE
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            JButton clicked = (JButton) e.getComponent();
            Check check = new Check(clicked);
        }
    };

    MouseAdapter m2 = new MouseAdapter() {                  //NEW GAME
        @Override
        public void mouseClicked(MouseEvent e) {
            boardPanel.removeAll();
            dispose();
            new GameFrame();
        }
    };

}


