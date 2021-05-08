package org.reg.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.reg.exceptions.PasswordIncorrectException;
import org.reg.services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Text message;
    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Administrator");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            Stage stage = new Stage();

            boolean test = UserService.checkUserDoesAlreadyExist(usernameField.getText(), passwordField.getText());
            Stage primaryStage = (Stage) loginButton.getScene().getWindow();
            primaryStage.close();
            if(test) {
                if(((String) role.getValue()).equals("Customer")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("customerPage.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                } else if (((String) role.getValue()).equals("Administrator")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("administratorPage.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            }

            if(!test) {
                if (((String) role.getValue()).equals("Customer")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("registerCustomer.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    RegisterControllerCustomer reg = loader.getController();
                    reg.setUsernameField(usernameField);
                    reg.setPasswordField(passwordField);
                    reg.setRole(role);
                } else if (((String) role.getValue()).equals("Administrator")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("registerAdministrator.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    RegisterControllerAdministrator reg = loader.getController();
                    reg.setUsernameField(usernameField);
                    reg.setPasswordField(passwordField);
                    reg.setRole(role);
                }
            }
        } catch (PasswordIncorrectException e) {
            message.setText(e.getMessage());
        } catch (IOException ee) {
            System.out.println("Eroare!!");
        }
    }
}