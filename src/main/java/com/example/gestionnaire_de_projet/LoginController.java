package com.example.gestionnaire_de_projet;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) {
        loginMessageLabel.setAlignment(Pos.CENTER);
        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password !!");
        }
    }

    public void validateLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "SELECT count(1) FROM member WHERE username = '" + usernameTextField.getText() + "\'AND password  =\'"+passwordTextField.getText()+"'";

        try {
         Statement statement = connectDB.createStatement();
         ResultSet queryResult = statement.executeQuery(verifyLogin);

         while(queryResult.next()){
             if(queryResult.getInt(1) == 1){

                 Parent root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
                 Stage stage = (Stage) loginButton.getScene().getWindow();
                 stage.setTitle("Page d'accueil");

                 stage.setScene(new Scene(root,520,400));

             }else{
                 loginMessageLabel.setText("Invalid login. Please Try again.");
             }
         }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
