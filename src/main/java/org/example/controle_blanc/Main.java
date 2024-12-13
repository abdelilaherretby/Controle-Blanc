package org.example.controle_blanc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Chemin corrigé pour accéder à Student.fxml
        Parent parent = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Superviseurs Système ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}