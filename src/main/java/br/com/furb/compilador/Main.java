package br.com.furb.compilador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        ViewController controller = fxmlLoader.getController();
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> controller.handleKeyEvents(event));

        System.out.println(scene.getWidth());

        stage.setTitle("FURB - Compilador");
        stage.setMinWidth(910);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
        System.out.println(scene.getWidth());
    }

    public static void main(String[] args) {
        launch();
    }
}