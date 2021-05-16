package org.reg;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reg.services.FileSystemService;
import org.reg.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


@ExtendWith(ApplicationExtension.class)

class MainTest {
    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Air BejiZescu");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }

    @Test
    void testRegistration(FxRobot robot){
        robot.clickOn("#name");
        robot.write("user11");
        robot.clickOn("#password");
        robot.write("password11");
        robot.clickOn("#role");
        robot.clickOn("Administrator");
        robot.clickOn("#regBut");
        robot.clickOn("#name");
        robot.write("user11");
        robot.clickOn("#eMail");
        robot.write("user11@gmail.com");
        robot.clickOn("#phoneNumber");
        robot.write("0722222222");
        robot.clickOn("#addFlights");
        robot.clickOn("#nameField");
        robot.write("Zbor 22");
        robot.clickOn("#codeField");
        robot.write("A636");
        robot.clickOn("#sourceField");
        robot.write("Motru");
        robot.clickOn("#destinationField");
        robot.write("Timisoara");
        robot.clickOn("#classField");
        robot.write("A");
        robot.clickOn("#capacityField");
        robot.write("15000");
        robot.clickOn("#saveBut");
        robot.clickOn("#backBut");
        robot.clickOn("#showBut");
        robot.clickOn("#backBut");
        robot.clickOn("#editBut");
        robot.clickOn("#backBut");
        robot.clickOn("#cancelBut");
        robot.clickOn("#backBut");
        robot.clickOn("#logoutBut");

    }
}