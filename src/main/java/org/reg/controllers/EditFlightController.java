package org.reg.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.reg.model.Flight;
import org.reg.model.User;
import org.reg.services.FlightService;
import org.reg.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class EditFlightController {

    @FXML
    TableView flightsTableView;

    @FXML
    private void initialize(){
        fillFlightsTableView();
        flightsTableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        codeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        destinationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        capacityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        flightClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sourceColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    TableColumn<Flight, String> codeColumn = new TableColumn<>("Code");
    TableColumn<Flight, String> nameColumn = new TableColumn<>("Name");
    TableColumn<Flight, String> sourceColumn = new TableColumn<>("Source");
    TableColumn<Flight, String> destinationColumn = new TableColumn<>("Destination");
    TableColumn<Flight, String> capacityColumn = new TableColumn<>("Capacity");
    TableColumn<Flight, String> flightClassColumn = new TableColumn<>("Flight Class");

    public void fillFlightsTableView(){
        User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

        codeColumn.setMinWidth(100);
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeColumn.setOnEditCommit(this::changeCodeCellEvent);

        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setOnEditCommit(this::changeNameCellEvent);

        sourceColumn.setMinWidth(100);
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));
        sourceColumn.setOnEditCommit(this::changeSourceCellEvent);

        destinationColumn.setMinWidth(100);
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        destinationColumn.setOnEditCommit(this::changeDestinationCellEvent);

        capacityColumn.setMinWidth(100);
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        capacityColumn.setOnEditCommit(this::changeCapacityCellEvent);

        flightClassColumn.setMinWidth(100);
        flightClassColumn.setCellValueFactory(new PropertyValueFactory<>("flightClass"));
        flightClassColumn.setOnEditCommit(this::changeFlightClassCellEvent);


        //coursesTableView.setEditable(true);
        if(flightsTableView.getColumns() != null) {
            flightsTableView.getColumns().add(codeColumn);
            flightsTableView.getColumns().add(nameColumn);
            flightsTableView.getColumns().add(sourceColumn);
            flightsTableView.getColumns().add(destinationColumn);
            flightsTableView.getColumns().add(capacityColumn);
            flightsTableView.getColumns().add(flightClassColumn);
        }

        if(user != null){
            for(Flight flight: FlightService.getFlightRepository().find()) {
                flightsTableView.getItems().add(flight);
            }
        }
    }

    public void changeSourceCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setSource(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setSource(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }

    public void changeCodeCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setCode(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setCode(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }

    public void changeNameCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setName(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setName(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }

    public void changeDestinationCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setDestination(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setDestination(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }

    public void changeCapacityCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setCapacity(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setCapacity(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }

    public void changeFlightClassCellEvent(TableColumn.CellEditEvent edittedCell){
        Flight flightSelected = (Flight) flightsTableView.getSelectionModel().getSelectedItem();
        String aux = flightSelected.getName();
        try {
            if (!edittedCell.getNewValue().toString().equals("")) {
                User user = UserService.getUserFromDatabase(LoginController.getLoggedUsername());

                Flight newFlight = FlightService.getFlightFromDatabase(aux);
                newFlight.setFlightClass(edittedCell.getNewValue().toString());
                System.out.println(aux);
                FlightService.getFlightRepository().update(newFlight);

                flightSelected.setFlightClass(edittedCell.getNewValue().toString());
            }
        } catch (Exception e){
            System.out.println("Eroare!");
        }
    }


    @FXML
    public void handleBack(javafx.event.ActionEvent adminPage) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("administratorPage.fxml"));
        Parent viewAdmin = Loader.load();
        Scene LoginScene = new Scene(viewAdmin, 650, 450);
        Stage window = (Stage) ((Node) adminPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }
}


