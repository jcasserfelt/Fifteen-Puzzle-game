import javax.swing.*;


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
        String tempString;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals("0")){
                    i0 = i;
                    j0 = j;
                }
                if (board[i][j].getText().equals(b.getText())) {
                    iKlick = i;
                    jKlick = j;
                    //JButton tempB = b;
                }
            }
        }
        /*todo: om vi tar bort de 4 if satserna, och kör replace direkt, do blir "FuskMode".
           Det kan vara användbart för att testa WinState: puzzlet är väldigt ofta olösbart.
           Vi skulle också kunna implementera fuskMode i programmet :)!
         */
        // to the left to the left
       if ((iKlick == i0) && (jKlick == (j0 - 1)))
            replace();
        // to the right to the right
        else if ((iKlick == i0) && (jKlick == (j0 + 1)))
            replace();
        // up
        else if ((iKlick == (i0 + 1)) && (jKlick == j0))
            replace();
        // down
        else if ((iKlick == (i0 - 1)) && (jKlick == j0))
            replace();
        
        /*else {
            //System.out.printf(" iKlick:\t%d\n jKlick:\t%d\n i0:\t\t%d\n j0:\t\t%d", iKlick, jKlick, i0, j0);
        }*/
        refreshVisables();
        //todo nytt namn för metoden swapwithNeibour? Vi har redan swappat, det är bara en ny "hideZero"...
        //todo två metoder som gör samma sak...skulle man kunna använda bara en?
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
        JOptionPane. showMessageDialog(null,"GRATTIS! DU VANN!");
    }

}
