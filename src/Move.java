import javax.swing.*;

public class Move {

    //INSTANSVARIABLER
    JButton[][] board;
    int i0, j0, iKlick, jKlick;
    int kindOfMove;
    private static final String[] WINSEQUENCE =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","0"};

    //-----------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Move(int i0, int j0, int iKlick, int jklick, int kindOfMove){
        this.board = GameFrame.board;
        this.kindOfMove = kindOfMove;
        this.i0 = i0;
        this.j0 = j0;
        this.iKlick = iKlick;
        this.jKlick = jklick;
        makeAMove();
    }

    //-----------------------------------------------------------------------------------------------
    //INSTANSMETODER
    public void makeAMove() {
            if (Check.fuskMode == true)
                replace();

            else
                if (kindOfMove == 1)
                    replace();                  //singleMove
                else if (kindOfMove == 2) {
                    doubleMove();               //replace + replace
                } else if (kindOfMove == 3) {   //replace + doubleMove
                    tripleMove();
                }

            refreshVisables();
            if (isWinState())
                showWinPanel();
            //Else : tillbaka till väntefas
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

        if  ((iKlick == i0) && (jKlick == (j0 - 3))) {  // 2moveright
            jKlick = jKlick + 2;                        // välj den närmaste till höger
            replace();                                  // swap med noll
            j0 = j0 - 1;                                // noll flyttas till vänster
            this.jKlick = jKlick - 2;                   // välj den ursprunliga klivken
            doubleMove();                               // swap till den nya nollen
        } else if
        ((iKlick == i0) && (jKlick == (j0 + 3))) {      // 2moveleft...)
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
        for (int i = 0; i < GameFrame.SIZE; i++) {
            for (int j = 0; j < GameFrame.SIZE; j++) {
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setVisible(false);
                } else board[i][j].setVisible(true);
            }
        }
    }


    public boolean isWinState(){
        int counter = 0;
        for (int i = 0; i < GameFrame.SIZE; i++) {
            for (int j = 0; j < GameFrame.SIZE; j++) {
                if (!(board[i][j].getText().equals(WINSEQUENCE[counter])))
                    return false;
                counter++;
            }
        }
        return true;
    }


    public void showWinPanel(){
        GameFrame.boardPanel.removeAll();
        GameFrame.boardPanel.setVisible(false);             //Refresh
        GameFrame.boardPanel.setVisible(true);
        JOptionPane. showMessageDialog(null,"GRATTIS! DU VANN!");

    }


} 	