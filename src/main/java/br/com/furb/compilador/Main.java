package br.com.furb.compilador;

import javafx.application.Application;
import javafx.css.Style;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 910, 600);

        ViewController controller = fxmlLoader.getController();
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> controller.handleKeyEvents(event));

        stage.setTitle("FURB - Compilador");
        stage.setMinWidth(910);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}