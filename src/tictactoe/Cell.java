/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Saad
 */
public class Cell extends StackPane {

    Rectangle rect;
    Text text;

    public Cell() {
        text = new Text();
        text.setStyle("-fx-font: "+(TicTacToe.height/6)+" arial;");

        rect = new Rectangle(TicTacToe.width/3, TicTacToe.height/3);
        rect.setFill(Color.CORNFLOWERBLUE);
        rect.setStroke(Color.ALICEBLUE);

        getChildren().add(rect);
        getChildren().add(text);

    }

    public void setText(String str,Paint fill){
        text.setText(str);
        text.setFill(fill);
        setDisable(true);
    }

    public String getText(){
        return text.getText();
    }

    public void setNullText(){
        this.text.setText("");
    }

}
