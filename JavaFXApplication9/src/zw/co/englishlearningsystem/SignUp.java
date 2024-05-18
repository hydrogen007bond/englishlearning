package zw.co.englishlearningsystem;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignUp {

    private Map<String, User> users;
    private final Alerts alert;

    public SignUp() {
        this.alert = new Alerts();
    }
    
    
         
    public void showSignUpPage(Stage primaryStage) {
        GridPane signUpPage = new GridPane();
        signUpPage.setPadding(new Insets(20));
        signUpPage.setVgap(10);
        signUpPage.setHgap(10);

        Label titleLabel = new Label("Sign Up");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        GridPane.setConstraints(titleLabel, 0, 0, 2, 1);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        GridPane.setConstraints(usernameField, 0, 1, 2, 1);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        GridPane.setConstraints(passwordField, 0, 2, 2, 1);

        Label ageLabel = new Label("Age:");
        GridPane.setConstraints(ageLabel, 0, 3);

        TextField ageField = new TextField();
        ageField.setPromptText("Age");
        GridPane.setConstraints(ageField, 1, 3);

        Label genderLabel = new Label("Gender:");
        GridPane.setConstraints(genderLabel, 0, 4);

        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(genderGroup);
        GridPane.setConstraints(maleRadioButton, 1, 4);

        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(genderGroup);
        GridPane.setConstraints(femaleRadioButton, 1, 5);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            int age = Integer.parseInt(ageField.getText());
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            String gender = selectedGender.getText();
            if (!username.isEmpty() && !password.isEmpty() && age > 0 && (selectedGender != null)) {
                users.put(username, new User(username, password, age, gender));
                alert.showAlert("Sign Up Successful", "You have successfully signed up!");
                //primaryStage.setScene(new Scene(createLoginPage(primaryStage), 300, 200));
            } else {
                alert.showAlert("Sign Up Failed", "Please fill in all fields.");
            }
        });
        GridPane.setConstraints(signUpButton, 0, 6, 2, 1);

        signUpPage.getChildren().addAll(titleLabel, usernameField, passwordField, ageLabel, ageField, genderLabel, maleRadioButton, femaleRadioButton, signUpButton);

        Scene scene = new Scene(signUpPage, 300, 250);
        primaryStage.setScene(scene);
    }

}
