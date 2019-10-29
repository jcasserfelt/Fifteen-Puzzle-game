import javax.swing.*;

public class Move {

    JButton[][] board;
    JPanel boardPanel;
    int i0, j0, iKlick, jKlick,SIZE;
    int kindOfMove;
    private static final String[] WINSEQUENCE =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};


    public Move(JButton[][] board, JPanel boardPanel, int SIZE, int i0, int j0, int iKlick, int jklick, int kindOfMove){
        this.board = board;
        this.SIZE = SIZE;
        this.boardPanel = boardPanel;
        this.kindOfMove = kindOfMove;
        this.i0 = i0;
        this.j0 = j0;
        this.iKlick = iKlick;
        this.jKlick = jklick;
        makeAMove();
    }


    public void makeAMove() {

            if (kindOfMove == 1)
                replace();                  //singleMove
            else if (kindOfMove == 2) {
                doubleMove();               //replace + replace
            }
            else if (kindOfMove == 3) {     //replace + doubleMove
                tripleMove();
            }
            refreshVisables();
            if (isWinState())
                showWinPanel();

    }

    //todo: fuskMode!
    //todo: hideZero, refreshVisible. Två metoder som gör samma sak...skulle man inte kunna använda bara en?

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