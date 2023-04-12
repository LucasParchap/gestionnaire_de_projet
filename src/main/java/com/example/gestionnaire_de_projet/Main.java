package com.example.gestionnaire_de_projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        stage.setTitle("Log-in");
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);

        Image icon = new Image(getClass().getResource("/Images/LogoEarth.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setScene(new Scene(root,520,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}