

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import zw.co.englishlearningsystem.*;

public class EnglishLearningSystem extends Application {

    private Map<String, User> users;
   
    private Login login;

    public EnglishLearningSystem() {
    }
    
    

    public EnglishLearningSystem(Map<String, User> users, Login login) {
        this.users = users;
        this.login = login;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("English Learning System");

        // Initialize the user map
        users = new HashMap<>();

        // Create login page
        VBox loginPage = createLoginPage(primaryStage);

        Scene scene = new Scene(loginPage, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLoginPage(Stage primaryStage) {
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
                showMainMenu(primaryStage, users.get(username));
            } else {
                showAlert("Login Failed", "Invalid username, password, or gender.");
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> showSignUpPage(primaryStage));

        loginPage.getChildren().addAll(titleLabel, usernameField, passwordField, ageLabel, maleRadioButton, femaleRadioButton, loginButton, signUpButton);
        return loginPage;
    }

    private void showSignUpPage(Stage primaryStage) {
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
                showAlert("Sign Up Successful", "You have successfully signed up!");
                primaryStage.setScene(new Scene(createLoginPage(primaryStage), 300, 200));
            } else {
                showAlert("Sign Up Failed", "Please fill in all fields.");
            }
        });
        GridPane.setConstraints(signUpButton, 0, 6, 2, 1);

        signUpPage.getChildren().addAll(titleLabel, usernameField, passwordField, ageLabel, ageField, genderLabel, maleRadioButton, femaleRadioButton, signUpButton);

        Scene scene = new Scene(signUpPage, 300, 250);
        primaryStage.setScene(scene);
    }

    private void showMainMenu(Stage primaryStage, User user) {
        VBox mainMenu = new VBox(10);
        mainMenu.setPadding(new Insets(20));

        Label welcomeLabel = new Label("Welcome, " + user.getUsername() + "!");
        welcomeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button vocabularyQuizButton = new Button("Vocabulary Quiz");
        vocabularyQuizButton.setOnAction(e -> showVocabularyQuizMenu(primaryStage, user));

        Button grammarExerciseButton = new Button("Grammar Exercise");
        // Add action event for grammar exercise button

        Button readingComprehensionButton = new Button("Reading Comprehension");
        // Add action event for reading comprehension button

        mainMenu.getChildren().addAll(welcomeLabel, vocabularyQuizButton, grammarExerciseButton, readingComprehensionButton);

        Scene scene = new Scene(mainMenu, 300, 200);
        primaryStage.setScene(scene);
    }

    private void showVocabularyQuizMenu(Stage primaryStage, User user) {
        VBox vocabularyQuizMenu = new VBox(10);
        vocabularyQuizMenu.setPadding(new Insets(20));

        Label titleLabel = new Label("Vocabulary Quiz Menu");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button startQuizButton = new Button("Start Quiz");
        // Add action event for starting the quiz

        vocabularyQuizMenu.getChildren().addAll(titleLabel, startQuizButton);

        Scene scene = new Scene(vocabularyQuizMenu, 300, 200);
        primaryStage.setScene(scene);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    class User{
    
        private String username;
    private String password;
    private int age;
    private String gender;

    public User(String username, String password, int age, String gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    }
}

