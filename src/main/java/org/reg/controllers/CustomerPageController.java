package org.reg.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerPageController {

    @FXML
    private Button logoutButton;
    @FXML
    private Button flightListButton;
    @FXML
    private Button enrollButton;
    @FXML
    private Button enrolledListButton;
    @FXML
    private Button accountButton;

    @FXML
    public void handleLogout(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("login.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 650, 450);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    @FXML
    public void handleShowFlights(javafx.event.ActionEvent flightsPage) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("viewFlightPageCustomer.fxml"));
        Parent viewFlights = Loader.load();
        Scene LoginScene = new Scene(viewFlights, 605, 470);
        Stage window = (Stage) ((Node) flightsPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    @FXML
    public void handleEnroll(javafx.event.ActionEvent enrollPage) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("enrollFlightPage.fxml"));
        Parent viewFlights = Loader.load();
        Scene LoginScene = new Scene(viewFlights, 605, 470);
        Stage window = (Stage) ((Node) enrollPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }
}
