/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saad
 */
public class Messager {

    Text text;

    public Messager(String str) {
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        ImageView im = null ;

        Image happy = new Image(Messager.class.getResourceAsStream("happy.png"));
        Image angry = new Image(Messager.class.getResourceAsStream("angry.png"));

        if(str.equals("You win!")){
            im = new ImageView(happy);
            im.setFitHeight(100);
            im.setFitWidth(100);
        }else{
            im = new ImageView(angry);
            im.setFitHeight(100);
            im.setFitWidth(100);
        }

        text = new Text(str);
        text.setStyle("-fx-font: 18 arial;");
        text.setFill(Color.LIGHTCYAN);

        BorderPane p = new BorderPane();

        VBox root = new VBox();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(10);

        root.setAlignment(Pos.CENTER);

        Button ok;

        ok = new Button("Ok");

        ok.setStyle("-fx-background-color: \n"
                + "        rgba(0,0,0,0.08),\n"
                + "        linear-gradient(#9a9a9a, #909090),\n"
                + "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n"
                + "    -fx-background-insets: 0 0 -1 0,0,1;\n"
                + "    -fx-background-radius: 5,5,4;\n"
                + "    -fx-padding: 3 30 3 30;\n"
                + "    -fx-text-fill: #242d35;\n"
                + "    -fx-font-size: 14px;");

        root.getChildren().addAll(text,im,ok);

        ok.setOnAction(e -> {
            primaryStage.hide();
            new TicTacToe().resetBoard();
        });

        p.setCenter(root);
        root.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        p.setStyle("-fx-effect: dropshadow(gaussian, blue, 200, 0, 0, 0);"
                + "-fx-background-insets: 200;");

        Scene scene = new Scene(p, 300, 200);
        scene.setFill(Color.TRANSPARENT);

        p.prefHeightProperty().bind(scene.heightProperty());
        p.prefWidthProperty().bind(scene.widthProperty());

        EffectUtilities.makeDraggable(primaryStage, p);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
