package org.reg.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.reg.model.Flight;
import org.reg.model.User;
import org.reg.services.FlightService;
import org.reg.services.UserService;

import java.io.IOException;
import java.util.Objects;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class AddFlightController {
    private static String username, id;
    private static String personalKey;
    private final ObjectRepository<User> REPOSITORY = UserService.getUserRepository();
    private ObservableList<Flight> flights;
    private static Stage stage = new Stage();

    @FXML
    private Button saveButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField code;
    @FXML
    private TextField name;
    @FXML
    private TextField source;
    @FXML
    private TextField destination;
    @FXML
    private TextField capacity;
    @FXML
    private TextField flightClass;

    @FXML
    public void handleSaveFlight() throws Exception {
        try {
            User loggedInUser=REPOSITORY.find(eq("username",username)).firstOrDefault();
            personalKey=loggedInUser.getPersonalKey();
            String id = NitriteId.newId().toString();
            FlightService.addFlight(id, personalKey, code.getText(), name.getText(), source.getText(), destination.getText(),
                    capacity.getText(), flightClass.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("addFlightPage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (saveButton.getScene().getWindow());
            AddFlightController controller = loader.getController();
            controller.setFlights(flights);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Eroare!!!");
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
    public void handleBack(javafx.event.ActionEvent back) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("administratorPage.fxml"));
        Parent viewAdmin = Loader.load();
        Scene AdminScene = new Scene(viewAdmin, 650, 450);
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow();
        window.setScene(AdminScene);
        window.show();
    }

    public void setUsername(String username){this.username = username;}

    public void setId(String id) {AddFlightController.id = id;}

    public void setPersonalKey(String personalKey){ this.personalKey = personalKey;}

    public static Stage getStage() { return stage; }

    public void setFlights(ObservableList<Flight> flights) { this.flights = flights; }

}
