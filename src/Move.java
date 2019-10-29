
import javax.swing.*;

public class Move {

    JButton clicked;
    JButton[][] board;
    JPanel boardPanel;
    int i0, j0, iKlick, jKlick,SIZE;
    int kindOfMove;
    private static final String[] WINSEQUENCE =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};


    public Move(JButton clicked, JButton[][] board, JPanel boardPanel, int SIZE){
        this.clicked = clicked;
        this.board = board;
        this.SIZE = SIZE;
        this.boardPanel = boardPanel;
        makeAMove();
    }


    public void makeAMove() {
        setCheckPoints();
        if (isMovePossible()) {
            if (kindOfMove == 1)
                replace();     //singleMove
            else if (kindOfMove == 2) {
                doubleMove();
            }
            else if (kindOfMove == 3) {
                tripleMove();
            }

            refreshVisables();
            if (isWinState())
                showWinPanel();
        }
    }

    //todo: fuskMode!
    //todo: hideZero, refreshVisible. Två metoder som gör samma sak...skulle man inte kunna använda bara en?


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
            System.out.println("Single move");
            return true;
        } else if
           ((iKlick == i0) && (jKlick == (j0 - 2)) ||    //2right
            (iKlick == i0) && (jKlick == (j0 + 2)) ||    //2left
            (iKlick == (i0 + 2)) && (jKlick == j0) ||    //2up
            (iKlick == (i0 - 2)) && (jKlick == j0)) {    //2down
             kindOfMove = 2;
             System.out.println("Double move");
             return true;
        } else if
            ((iKlick == i0) && (jKlick == (j0 - 3)) ||    //3right
             (iKlick == i0) && (jKlick == (j0 + 3)) ||    //3left
             (iKlick == (i0 + 3)) && (jKlick == j0) ||    //3up
             (iKlick == (i0 - 3)) && (jKlick == j0)) {    //3down
              kindOfMove = 3;
              System.out.println("Triple move");
              return true;
        }
        return false;
    }




    private void replace(){
        String tempString;
        tempString = board[i0][j0].getText();
        board[i0][j0].setText(board[iKlick][jKlick].getText());
        board[iKlick][jKlick].setText(tempString);
    }

    private void doubleMove() {

        if  ((iKlick == i0) && (jKlick == (j0 - 2))) {  //2moveright
            jKlick = jKlick + 1;                        //fört den första till höger
            replace();                                  // swap med noll
            j0 = j0 - 1;                                // noll flyttas till vänster
            this.jKlick = jKlick - 1;                   // vi får den ursprunliga klivken
            replace();                                  // swap til den nya nollen
        } else if
            ((iKlick == i0) && (jKlick == (j0 + 2))) {  //2moveleft)
            jKlick = jKlick - 1;
            replace();
            j0 = j0 + 1;
            this.jKlick = jKlick + 1;
            replace();
        } else if
            ((iKlick == (i0 + 2)) && (jKlick == j0)){
            iKlick = iKlick - 1;
            replace();
            i0 = i0 + 1;
            this.iKlick = iKlick + 1;
            replace();
        } else if
            ((iKlick == (i0 - 2)) && (jKlick == j0)){
            iKlick = iKlick + 1;
            replace();
            i0 = i0 - 1;
            this.iKlick = iKlick - 1;
            replace();
        }
    }

    private void tripleMove() {

        if  ((iKlick == i0) && (jKlick == (j0 - 3))) {  //2moveright
            jKlick = jKlick + 2;                        //fört den första till höger
            replace();                                  // swap med noll
            j0 = j0 - 1;                                // noll flyttas till vänster
            this.jKlick = jKlick - 2;                   // vi får den ursprunliga klivken
            doubleMove();                               // swap til den nya nollen
        } else if
        ((iKlick == i0) && (jKlick == (j0 + 3))) {      //2moveleft)
            jKlick = jKlick - 2;
            replace();
            j0 = j0 + 1;
            this.jKlick = jKlick + 2;
            doubleMove();
        } else if
        ((iKlick == (i0 + 3)) && (jKlick == j0)){
            iKlick = iKlick - 2;
            replace();
            i0 = i0 + 1;
            this.iKlick = iKlick + 2;
            doubleMove();
        } else if
        ((iKlick == (i0 - 3)) && (jKlick == j0)){
            iKlick = iKlick + 2;
            replace();
            i0 = i0 - 1;
            this.iKlick = iKlick - 2;
            doubleMove();
        }
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