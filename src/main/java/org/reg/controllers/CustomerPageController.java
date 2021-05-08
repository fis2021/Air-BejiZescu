package org.reg.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerPageController {

    @FXML
    private Button logoutButton;
    @FXML
    private Button flightListButton;
    @FXML
    private Button enrolledListButton;
    @FXML
    private Button paymentButton;
    @FXML
    private Button accountButton;

    @FXML
    public void handleLogout() {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
}
