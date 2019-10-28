import javax.swing.*;
import java.awt.*;

public class Move {

    JButton b;
    JButton[][] board;
    JPanel boardPanel;
    int i0, j0, iKlick, jKlick,SIZE;
    private static final String[] WINSEQUENCE =
    {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};


    public Move(JButton b, JButton[][] board, JPanel boardPanel, int SIZE){
        this.b = b;
        this.board = board;
        this.SIZE = SIZE;
        this.boardPanel = boardPanel;
        makeAMove(b);
    }

    //todo: andra metoder? SetNollPoint,  SetClickPoint?
    private void makeAMove(JButton b) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals("0")){
                    i0 = i;
                    j0 = j;
                }
                if (board[i][j].getText().equals(b.getText())) {
                    iKlick = i;
                    jKlick = j;
                }
            }
        }
        /*todo: om vi tar bort de 4 if satserna, och kör replace direkt, do blir "FuskMode".
           Det kan vara användbart för att testa WinState: puzzlet är väldigt ofta olösbart.
           Vi skulle också kunna implementera fuskMode i programmet :)!
         */

        if ((iKlick == i0) && (jKlick == (j0 - 1)))
            replace();// left
        else if ((iKlick == i0) && (jKlick == (j0 + 1)))
            replace();// right
        else if ((iKlick == (i0 + 1)) && (jKlick == j0))
            replace();// up
        else if ((iKlick == (i0 - 1)) && (jKlick == j0))
            replace();// down

        refreshVisables();

        //todo: hideZero, refreshVisible. Två metoder som gör samma sak...skulle man kunna använda bara en?
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
        checkWinState();
    }


    public void checkWinState(){
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!(board[i][j].getText().equals(WINSEQUENCE[counter])))
                    return;
                counter++;
            }
        }
        showWinPanel();
    }

    public void showWinPanel(){
        boardPanel.removeAll();
        //vi behöver någon sorts "refresh", det enda som jag hittate är det...
        boardPanel.setVisible(false);
        boardPanel.setVisible(true);
        JOptionPane. showMessageDialog(null,"GRATTIS! DU VANN!");

    }


}
