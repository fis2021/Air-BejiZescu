package org.reg.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.reg.services.UserService;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class RegisterControllerAdministrator {

    private String usernameField;
    private String passwordField;
    private String role;

    @FXML
    private TextField name;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField eMail;
    @FXML
    private TextField nameOfAgency;
    @FXML
    private Button saveButton;

    @FXML
    public void handleRegisterAgent() throws Exception{
        try {
            UserService.addUser(usernameField, passwordField, role, name.getText(), eMail.getText(), phoneNumber.getText(), nameOfAgency.getText());
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("administratorPage.fxml"));
            Stage stage = (Stage) (saveButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Eroare!!");
        }
    }

    public void setUsernameField(TextField username) {
        this.usernameField = username.getText();
    }

    public void setPasswordField(PasswordField password) {
        this.passwordField = password.getText();
    }

    public void setRole(ChoiceBox<String> role) {
        this.role = role.getValue();
    }
}
