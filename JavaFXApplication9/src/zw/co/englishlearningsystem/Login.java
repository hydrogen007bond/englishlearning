
package zw.co.englishlearningsystem;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {
    
     private Map<String, User> users;
     private Alerts alert;
     private Menu menu;
     private SignUp signUpPage;

    public Login() {
    }
     
    public Login(Map<String, User> users, Alerts alert, Menu menu, SignUp signUpPage) {
        this.users = users;
        this.alert = alert;
        this.menu = menu;
        this.signUpPage = signUpPage;
    }
       
     public VBox createLoginPage(Stage primaryStage) {
        VBox loginPage = new VBox(10);
        loginPage.setPadding(new Insets(20));

        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label ageLabel = new Label("Age:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(genderGroup);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(genderGroup);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            if (selectedGender != null && users.containsKey(username) && users.get(username).getPassword().equals(password)) {
                // Login successful, show main menu
                menu.showMainMenu(primaryStage, users.get(username));
            } else {
                alert.showAlert("Login Failed", "Invalid username, password, or gender.");
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> signUpPage.showSignUpPage(primaryStage));

        loginPage.getChildren().addAll(titleLabel, usernameField, passwordField, ageLabel, maleRadioButton, femaleRadioButton, loginButton, signUpButton);
        return loginPage;
    }
}
