package org.reg.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.reg.model.Flight;
import org.reg.services.FlightService;

import java.io.IOException;
import java.util.Objects;

public class AdministratorPageController {
    private static ObservableList<Flight> flights;
    private String username, personalKey;
    private final ObjectRepository<Flight> REPOSITORY = FlightService.getFlightRepository();
    private static Stage stage = new Stage();


    @FXML
    private Button logoutButton;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button flightListButton;

    @FXML
    public void handleAddFlight(javafx.event.ActionEvent addFlight) throws Exception {
        ObservableList<Flight> newList = FXCollections.observableArrayList();
        for(Flight flight:FlightService.getFlightRepository().find()) {
            if(Objects.equals(personalKey, flight.getPersonalKey())) {
                newList.add(flight);
            }
        }
        flights = newList;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("addFlightPage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (addButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
            AddFlightController addController = loader.getController();
            addController.setUsername(username);
            addController.setPersonalKey(personalKey);
            addController.setFlights(flights);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void handleEdit(){
        try {
            Stage stage = (Stage) editButton.getScene().getWindow();
            Parent viewRegisterRoot = FXMLLoader.load(getClass().getClassLoader().getResource("editFlightPage.fxml"));
            Scene scene = new Scene(viewRegisterRoot, 900, 480);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        Loader.setLocation(getClass().getClassLoader().getResource("viewFlightPage.fxml"));
        Parent viewFlights = Loader.load();
        Scene LoginScene = new Scene(viewFlights, 605, 470);
        Stage window = (Stage) ((Node) flightsPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    @FXML
    public void handleDeleteFlight(javafx.event.ActionEvent deleteFlightsPage) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("deleteFlightPage.fxml"));
        Parent viewFlights = Loader.load();
        Scene LoginScene = new Scene(viewFlights, 651, 544);
        Stage window = (Stage) ((Node) deleteFlightsPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    public void setUsername(String username){ this.username = username;}

    public void setPersonalKey(String personalKey) {this.personalKey = personalKey;}

    public static ObservableList<Flight> getFlights() {return flights;}

    public static Stage getStage() {return stage;}
}
