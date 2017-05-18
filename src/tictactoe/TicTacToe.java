package tictactoe;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Saad
 */
public class TicTacToe extends Application {

    public static int height = 600, width = 600;

    public static Cell[][] arr = new Cell[3][3];
    GridPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new GridPane();

        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("TicTacToe!");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = new Cell();
                int x = i;
                int y = j;
                arr[i][j].setOnMouseClicked(e -> {
                    userClicked(x, y);
                    if (testCompleteness()) {
                        resetBoard();
                    }
                });
                root.add(arr[i][j], j, i);
            }
        }
    }

    public void userClicked(int i, int j) {
        System.out.println("pressed pos " + i + "," + j);
        arr[i][j].setText("X", Color.LIGHTCYAN);

        if (testWinner("X")) {
            new Messager("You win!");
            return;
        }

        if (testCompleteness()) {
            new Timeline().getKeyFrames().add(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    resetBoard();
                }
            }));
        }

        Timeline timeline = new Timeline();

        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                new AIResponser().check();
                if (testWinner("O")) {
                    new Messager("You lose!");
                }

                if (testCompleteness()) {
                    new Timeline().getKeyFrames().add(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            resetBoard();
                        }
                    }));
                }
            }
        };

        KeyFrame keyFrame = new KeyFrame(Duration.millis(200), onFinished);

        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
    }

    public boolean testWinner(String str) {

        //loop for rows
        for (int i = 0; i < 3; i++) {
            System.out.println("row ==> " + arr[i][0].getText() + "\t" + arr[i][1].getText() + "\t" + arr[i][2].getText());
            if (arr[i][0].getText().equals(arr[i][1].getText()) && arr[i][0].getText().equals(arr[i][2].getText()) && arr[i][0].getText().equals(str)) {
                return true;
            } else if (arr[i][1].getText().equals(arr[i][2].getText()) && arr[i][1].getText().equals(arr[i][0].getText()) && arr[i][1].getText().equals(str)) {
                return true;
            } else if (arr[i][0].getText().equals(arr[i][2].getText()) && arr[i][0].getText().equals(arr[i][1].getText()) && arr[i][2].getText().equals(str)) {
                return true;
            }
        }

        //loop for columns
        for (int i = 0; i < 3; i++) {
            System.out.println("col ==> " + arr[0][i].getText() + "\t" + arr[1][i].getText() + "\t" + arr[2][i].getText());
            if (arr[0][i].getText().equals(arr[1][i].getText()) && arr[0][i].getText().equals(arr[2][i].getText()) && arr[0][i].getText().equals(str)) {
                return true;
            } else if (arr[1][i].getText().equals(arr[2][i].getText()) && arr[1][i].getText().equals(arr[0][i].getText()) && arr[1][i].getText().equals(str)) {
                return true;
            } else if (arr[0][i].getText().equals(arr[2][i].getText()) && arr[0][i].getText().equals(arr[1][i].getText()) && arr[2][i].getText().equals(str)) {
                return true;
            }
        }

        //check for diagonals
        System.out.println("diagonal ==> " + arr[0][0].getText() + "\t" + arr[1][1].getText() + "\t" + arr[2][2].getText());
        if (arr[0][0].getText().equals(arr[1][1].getText()) && arr[0][0].getText().equals(arr[2][2].getText()) && arr[0][0].getText().equals(str)) {
            return true;
        } else if (arr[1][1].getText().equals(arr[2][2].getText()) && arr[1][1].getText().equals(arr[0][0].getText()) && arr[1][1].getText().equals(str)) {
            return true;
        } else if (arr[0][0].getText().equals(arr[2][2].getText()) && arr[0][0].getText().equals(arr[1][1].getText()) && arr[2][2].getText().equals(str)) {
            return true;
        }

        System.out.println("rev diagonal ==> " + arr[0][2].getText() + "\t" + arr[1][1].getText() + "\t" + arr[2][0].getText());
        if (arr[0][2].getText().equals(arr[2][0].getText()) && arr[0][2].getText().equals(arr[1][1].getText()) && arr[0][2].getText().equals(str)) {
            return true;
        } else if (arr[0][2].getText().equals(arr[1][1].getText()) && arr[0][2].getText().equals(arr[2][0].getText()) && arr[2][0].getText().equals(str)) {
            return true;
        } else if (arr[1][1].getText().equals(arr[2][0].getText()) && arr[1][1].getText().equals(arr[0][2].getText()) && arr[1][1].getText().equals(str)) {
            return true;
        }

        return false;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j].setDisable(false);
                arr[i][j].setNullText();
            }
        }
    }

    public boolean testCompleteness() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
