package br.com.furb.compilador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CompiladorApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        ViewController controller = fxmlLoader.getController();
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> controller.handleKeyEvents(event));

        stage.setTitle("FURB - Compilador");
        stage.setMinWidth(910.00);
        stage.setMinHeight(600.00);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}