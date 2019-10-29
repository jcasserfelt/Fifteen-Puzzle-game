
import javax.swing.*;
import java.awt.*;

public class Move {

    JButton clicked;
    JButton[][] board;
    JPanel boardPanel;
    int i0, j0, iKlick, jKlick,SIZE;
    private static final String[] WINSEQUENCE =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};


    public Move(JButton clicked, JButton[][] board, JPanel boardPanel, int SIZE){
        this.clicked = clicked;
        this.board = board;
        this.SIZE = SIZE;
        this.boardPanel = boardPanel;
        makeAMove(clicked);
    }


    public void makeAMove(JButton clicked) {
        setSwapPoints();
        //if (isMovePossible()) {
            replace();
            refreshVisables();
            if (isWinState())
                showWinPanel();
        //}
    }
    //todo: fuskMode!
    //todo: hideZero, refreshVisible. Två metoder som gör samma sak...skulle man inte kunna använda bara en?


    public void setSwapPoints(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals("0")){
                    i0 = i;
                    j0 = j;
                }
                if (board[i][j].getText().equals(clicked.getText())) {
                    iKlick = i;
                    jKlick = j;
                }
            }
        }
    }


    public boolean isMovePossible(){
        if ((iKlick == i0) && (jKlick == (j0 - 1)) ||    //left
                (iKlick == i0) && (jKlick == (j0 + 1)) ||    //right
                (iKlick == (i0 + 1)) && (jKlick == j0) ||    //down
                (iKlick == (i0 - 1)) && (jKlick == j0))      //upp
            return true;
        else
            return false;
    }


    private void replace(){
        String tempString;
        tempString = board[i0][j0].getText();
        board[i0][j0].setText(board[iKlick][jKlick].getText());
        board[iKlick][jKlick].setText(tempString);
    }


    private void refreshVisables() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setVisible(false);
                } else board[i][j].setVisible(true);
            }
        }
    }


    public boolean isWinState(){
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!(board[i][j].getText().equals(WINSEQUENCE[counter])))
                    return false;
                counter++;
            }
        }
        return true;
    }


    public void showWinPanel(){
        boardPanel.removeAll();
        //vi behöver någon sorts "refresh", det enda som jag hittate är det...
        boardPanel.setVisible(false);
        boardPanel.setVisible(true);
        JOptionPane. showMessageDialog(null,"GRATTIS! DU VANN!");

    }


} 	