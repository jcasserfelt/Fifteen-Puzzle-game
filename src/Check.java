import javax.swing.*;

public class Check {

    //VARIABLER
    static boolean fuskMode = false;
    JButton clicked;
    int i0, j0, iKlick, jKlick;
    int kindOfMove;

    //-------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Check (JButton clicked){
        this.clicked = clicked;
        setCheckPoints();
        if(isMovePossible()){
            Move move = new Move(i0, j0, iKlick, jKlick, kindOfMove);
        }
    }
    //-------------------------------------------------------------------------------------------------
    //INSTANSMETODER
    public void setCheckPoints(){
        for (int i = 0; i < GameFrame.SIZE; i++) {
            for (int j = 0; j < GameFrame.SIZE; j++) {
                if (GameFrame.board[i][j].getText().equals("0")){
                    i0 = i;
                    j0 = j;
                }
                if (GameFrame.board[i][j].getText().equals(clicked.getText())) {
                    iKlick = i;
                    jKlick = j;
                }
            }
        }
    }


    public boolean isMovePossible() {
        if (fuskMode==true)
            return true;

        if ((iKlick == i0) && (jKlick == (j0 - 1)) ||    //moveright
            (iKlick == i0) && (jKlick == (j0 + 1)) ||    //moveleft
            (iKlick == (i0 + 1)) && (jKlick == j0) ||    //moveupp
            (iKlick == (i0 - 1)) && (jKlick == j0)) {    //moveDown
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