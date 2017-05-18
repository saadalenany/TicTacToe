package tictactoe;

import javafx.scene.paint.Color;
import static tictactoe.TicTacToe.*;

/**
 *
 * @author Saad
 */
public class AIResponser {

    public void check() {

        //check if there is a chance of winning
        if (checkWinningOrStoppingHim("O")) {
            return;
        } //check if there is a chance to stop him
        else if (checkWinningOrStoppingHim("X")) {
            return;
        } //check if there is an O alone & put by it's side
        else if (putObypreviousSide()) {
            return;
        } //generate random position for O at the beginning of the game
        else {
            generateO();
            return;
        }

    }

    public boolean checkWinningOrStoppingHim(String str) {
        //loop for rows
        for (int i = 0; i < 3; i++) {
            if (arr[i][0].getText().equals(arr[i][1].getText()) && arr[i][0].getText().equals(str) && arr[i][2].getText().equals("")) {
                System.out.println("O been set "+i+","+2);
                arr[i][2].setText("O", Color.BROWN);
                return true;
            } else if (arr[i][1].getText().equals(arr[i][2].getText()) && arr[i][1].getText().equals(str) && arr[i][0].getText().equals("")) {
                System.out.println("O been set "+i+","+0);
                arr[i][0].setText("O", Color.BROWN);
                return true;
            } else if (arr[i][0].getText().equals(arr[i][2].getText()) && arr[i][0].getText().equals(str) && arr[i][1].getText().equals("")) {
                System.out.println("O been set "+i+","+1);
                arr[i][1].setText("O", Color.BROWN);
                return true;
            }
        }

        //loop for columns
        for (int i = 0; i < 3; i++) {
            if (arr[0][i].getText().equals(arr[1][i].getText()) && arr[0][i].getText().equals(str) && arr[2][i].getText().equals("")) {
                System.out.println("O been set "+2+","+i);
                arr[2][i].setText("O", Color.BROWN);
                return true;
            } else if (arr[1][i].getText().equals(arr[2][i].getText()) && arr[1][i].getText().equals(str) && arr[0][i].getText().equals("")) {
                System.out.println("O been set "+0+","+i);
                arr[0][i].setText("O", Color.BROWN);
                return true;
            } else if (arr[0][i].getText().equals(arr[2][i].getText()) && arr[0][i].getText().equals(str) && arr[1][i].getText().equals("")) {
                System.out.println("O been set "+1+","+i);
                arr[1][i].setText("O", Color.BROWN);
                return true;
            }
        }

        //check for diagonals
        if (arr[0][0].getText().equals(arr[1][1].getText()) && arr[0][0].getText().equals(str) && arr[2][2].getText().equals("")) {
            arr[2][2].setText("O", Color.BROWN);
            return true;
        } else if (arr[1][1].getText().equals(arr[2][2].getText()) && arr[1][1].getText().equals(str) && arr[0][0].getText().equals("")) {
            arr[0][0].setText("O", Color.BROWN);
            return true;
        } else if ((arr[0][0].getText().equals(arr[2][2].getText()) && arr[0][0].getText().equals(str) && arr[1][1].getText().equals(""))
                || (arr[0][2].getText().equals(arr[2][0].getText()) && arr[0][2].getText().equals(str) && arr[1][1].getText().equals(""))) {
            arr[1][1].setText("O", Color.BROWN);
            return true;
        } else if (arr[0][2].getText().equals(arr[1][1].getText()) && arr[0][2].getText().equals(str) && arr[2][0].getText().equals("")) {
            arr[2][0].setText("O", Color.BROWN);
            return true;
        } else if (arr[1][1].getText().equals(arr[2][0].getText()) && arr[1][1].getText().equals(str) && arr[0][2].getText().equals("")) {
            arr[0][2].setText("O", Color.BROWN);
            return true;
        }

        return false;
    }

    public boolean putObypreviousSide() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //put O after previous
                if (j < 2) {
                    if (arr[i][j].getText().equals("O") && arr[i][j+1].getText().equals("")){
                        arr[i][j+1].setText("O",Color.BROWN);
                        return true;
                    }
                }
                //put O before previous
                if (j > 0) {
                    if (arr[i][j].getText().equals("O") && arr[i][j-1].getText().equals("")){
                        arr[i][j-1].setText("O",Color.BROWN);
                        return true;
                    }
                }
                //put O below previous
                if (i < 2) {
                    if (arr[i][j].getText().equals("O") && arr[i+1][j].getText().equals("")){
                        arr[i+1][j].setText("O",Color.BROWN);
                        return true;
                    }
                }
                //put O over previous
                if (i > 0) {
                    if (arr[i][j].getText().equals("O") && arr[i-1][j].getText().equals("")){
                        arr[i-1][j].setText("O",Color.BROWN);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void generateO() {
        int x=0 , y=0 ;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].getText().equals("X")){
                    x = i;
                    y = j;
                }
            }
        }

        int rand1 = (int) (Math.random()*3);
        int rand2 = (int) (Math.random()*3);
        do{
            rand1 = (int) (Math.random()*3);
            rand2 = (int) (Math.random()*3);
        }while(rand1==x && rand2==y);

        arr[rand1][rand2].setText("O", Color.BROWN);
        return;
    }

}
