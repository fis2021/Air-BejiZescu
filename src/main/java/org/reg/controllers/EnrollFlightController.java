package org.reg.controllers;

import javafx.event.ActionEvent;
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
import javafx.util.Callback;
import org.reg.model.Flight;
import org.reg.model.User;
import org.reg.services.FlightService;
import org.reg.services.UserService;

import java.io.IOException;
import java.util.ArrayList;


public class EnrollFlightController {

    @FXML
    Button backButton;
    @FXML
    Button enrollButton;
    @FXML
    TableView flightsTableView;

    @FXML
    private void initialize(){
        fillFlightsTableView();
        flightsTableView.setEditable(true);
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

        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        sourceColumn.setMinWidth(100);
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));

        destinationColumn.setMinWidth(100);
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));

        capacityColumn.setMinWidth(100);
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        flightClassColumn.setMinWidth(100);
        flightClassColumn.setCellValueFactory(new PropertyValueFactory<>("flightClass"));


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

    @FXML
    private void handleViewEnroll(ActionEvent actionEvent) {
        TableColumn<Flight, Void> colBtn = new TableColumn();

        Callback<TableColumn<Flight, Void>, TableCell<Flight, Void>> cellFactory = new Callback<TableColumn<Flight, Void>, TableCell<Flight, Void>>() {
            @Override
            public TableCell<Flight, Void> call(final TableColumn<Flight, Void> param) {
                final TableCell<Flight, Void> cell = new TableCell<Flight, Void>() {

                    private final Button btn = new Button("Enroll");
                    {
                        btn.setOnAction((ActionEvent event) -> {

                            Flight selectedFlight = getTableView().getItems().get(getIndex());

                            String name = UserService.getUserFromDatabase(LoginController.getLoggedUsername()).getName();
                            selectedFlight.getEnrolledPassengers().add(name);

                            FlightService.getFlightRepository().update(selectedFlight);
                            btn.setDisable(true);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        flightsTableView.getColumns().add(colBtn);

        enrollButton.setDisable(true);

    }

    @FXML
    public void handleBackCustomer(javafx.event.ActionEvent customerPage) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("customerPage.fxml"));
        Parent viewCustomer = Loader.load();
        Scene LoginScene = new Scene(viewCustomer, 650, 450);
        Stage window = (Stage) ((Node) customerPage.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

}
