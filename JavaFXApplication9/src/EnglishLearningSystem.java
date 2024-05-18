import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zw.co.englishlearningsystem.Login;
import zw.co.englishlearningsystem.User;

import java.util.HashMap;
import java.util.Map;

public class EnglishLearningSystem extends Application {

    private final Login login = new Login();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("English Learning System");

        // Initialize the user map
        Map<String, User> users = new HashMap<>();
        // Create login page
        VBox loginPage = login.createLoginPage(primaryStage);
        Scene scene = new Scene(loginPage, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}