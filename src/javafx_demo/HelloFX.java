package javafx_demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // without reading *fxml file for creation of the Stage instance
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); root.setHgap(10); root.setVgap(10);

        primaryStage.setTitle("Newborn to FX world!");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}
