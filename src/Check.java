import javax.swing.*;

public class Check {
    JButton clicked;
    JButton[][] board;
    JPanel boardPanel;
    int i0, j0, iKlick, jKlick,SIZE;
    int kindOfMove;

    public Check (JButton clicked, JButton[][] board, int SIZE){
        this.clicked = clicked;
        this.board = board;
        this.SIZE = SIZE;
        setCheckPoints();
        if(isMovePossible()){
            Move move = new Move( board, boardPanel, SIZE, i0, j0, iKlick, jKlick, kindOfMove);
        }
    }


    public void setCheckPoints(){
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


    public boolean isMovePossible() {
        if ((iKlick == i0) && (jKlick == (j0 - 1)) ||  //moveright
                (iKlick == i0) && (jKlick == (j0 + 1)) ||  //moveleft
                (iKlick == (i0 + 1)) && (jKlick == j0) ||  //moveupp
                (iKlick == (i0 - 1)) && (jKlick == j0)) {  //moveDown
            kindOfMove = 1;
            return true;
        } else if
        ((iKlick == i0) && (jKlick == (j0 - 2)) ||    //2right
                        (iKlick == i0) && (jKlick == (j0 + 2)) ||    //2left
                        (iKlick == (i0 + 2)) && (jKlick == j0) ||    //2up
                        (iKlick == (i0 - 2)) && (jKlick == j0)) {    //2down
            kindOfMove = 2;
            return true;
        } else if
        ((iKlick == i0) && (jKlick == (j0 - 3)) ||    //3right
                        (iKlick == i0) && (jKlick == (j0 + 3)) ||    //3left
                        (iKlick == (i0 + 3)) && (jKlick == j0) ||    //3up
                        (iKlick == (i0 - 3)) && (jKlick == j0)) {    //3down
            kindOfMove = 3;
            return true;
        }
        return false;
    }



}
