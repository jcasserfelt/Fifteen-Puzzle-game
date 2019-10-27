import javax.swing.*;

public class Move {

    JButton b;
    JButton[][] board;
    int i0, j0, iKlick, jKlick,SIZE;

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
                    //JButton tempB = b;
                }
                if (board[i][j].getText().equals(b.getText())) {
                    iKlick = i;
                    jKlick = j;
                    JButton tempB = b;
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
        } else {
            //System.out.printf(" iKlick:\t%d\n jKlick:\t%d\n i0:\t\t%d\n j0:\t\t%d", iKlick, jKlick, i0, j0);
        }
    }

    private void swapwithNeibour() {
        /*String tempString = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals(b.getText())) {
                    tempString = board[i][j - 1].getText();
                    board[i][j - 1].setText(b.getText());
                    b.setText(tempString);
                    // this does not work
                    if (board[i][j - 1].getText().equals("0")) {
                        b.setVisible(false);
                        board[i][j - 1].setVisible(true);
                    }
                }
            }
        }
        */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setVisible(false);
                } else board[i][j].setVisible(true);
            }
        }
    }
}
