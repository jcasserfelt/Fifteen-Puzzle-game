import javax.swing.*;


public class Move {

    JButton b;
    JButton[][] board;
    int i0, j0, iKlick, jKlick,SIZE;
    private static final String[] WINSERIE = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};


    public Move(JButton b, JButton[][] board, int SIZE){
        this.b = b;
        this.board = board;
        this.SIZE = SIZE;
        makeAMove(b);
    }


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
        // to the left to the left
        if ((iKlick == i0) && (jKlick == (j0 - 1))) {
            tempString = board[i0][j0].getText();
            board[i0][j0].setText(board[iKlick][jKlick].getText());
            board[iKlick][jKlick].setText(tempString);
            swapwithNeibour();
        }
        // to the right to the right
        else if ((iKlick == i0) && (jKlick == (j0 + 1))) {
            tempString = board[i0][j0].getText();
            board[i0][j0].setText(board[iKlick][jKlick].getText());
            board[iKlick][jKlick].setText(tempString);
            swapwithNeibour();
        }
        // up
        else if ((iKlick == (i0 + 1)) && (jKlick == j0)) {
            tempString = board[i0][j0].getText();
            board[i0][j0].setText(board[iKlick][jKlick].getText());
            board[iKlick][jKlick].setText(tempString);
            swapwithNeibour();
        }
        // down
        else if ((iKlick == (i0 - 1)) && (jKlick == j0)) {
            tempString = board[i0][j0].getText();
            board[i0][j0].setText(board[iKlick][jKlick].getText());
            board[iKlick][jKlick].setText(tempString);
            swapwithNeibour();
            //todo nytt namn för metoden? Vi har redan swappat, det är bara en ny "hideZero"...
            //todo två metoder som gör samma sak...skulle man kunna använda bara en?
        } else {
            //System.out.printf(" iKlick:\t%d\n jKlick:\t%d\n i0:\t\t%d\n j0:\t\t%d", iKlick, jKlick, i0, j0);
        }
    }

    private void swapwithNeibour() {
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
                if (!(board[i][j].getText().equals(WINSERIE[counter])))
                    return;
                counter++;
            }
        }
        System.out.println("WIN");
        //todo ersätta system out med en WinPanel(annan instansmetod?)
    }
}
