package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.Database.DatabaseHandler;
import sample.Model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpFirstName;

    @FXML
    private JFXTextField singUpLastName;

    @FXML
    private JFXTextField signUpUsername;

    @FXML
    private JFXTextField signUpLocation;

    @FXML
    private JFXCheckBox singUpCheckBoxMale;

    @FXML
    private JFXCheckBox singUpCheckBoxFemale;

    @FXML
    private JFXPasswordField signUpPassword;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void initialize() {


        signUpButton.setOnAction(event -> {
          createUser();
        });


    }

    private void  createUser(){
        DatabaseHandler databaseHandler=new DatabaseHandler();

        String name = signUpFirstName.getText();
        String lastName = singUpLastName.getText();
        String userName = signUpUsername.getText();
        String password = signUpPassword.getText();
        String location = signUpLocation.getText();


        String gender;
        if (singUpCheckBoxFemale.isSelected()) {
            gender = "Female";
        } else gender = "Male";


        User user = new User(name, lastName, userName, password, location, gender);
        databaseHandler.signUpUser(user);


    }
}