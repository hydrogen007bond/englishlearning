
package zw.co.englishlearningsystem;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {
    
    private ShowQuiz showQuiz;

    public Menu(ShowQuiz showQuiz) {
        this.showQuiz = showQuiz;
    }

    public Menu() {
    }
        
    public void showMainMenu(Stage primaryStage, User user) {
        VBox mainMenu = new VBox(10);
        mainMenu.setPadding(new Insets(20));

        Label welcomeLabel = new Label("Welcome, " + user.getUsername() + "!");
        welcomeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button vocabularyQuizButton = new Button("Vocabulary Quiz");
        vocabularyQuizButton.setOnAction(e -> showQuiz.showVocabularyQuizMenu(primaryStage, user));

        Button grammarExerciseButton = new Button("Grammar Exercise");
        // Add action event for grammar exercise button

        Button readingComprehensionButton = new Button("Reading Comprehension");
        // Add action event for reading comprehension button

        mainMenu.getChildren().addAll(welcomeLabel, vocabularyQuizButton, grammarExerciseButton, readingComprehensionButton);

        Scene scene = new Scene(mainMenu, 300, 200);
        primaryStage.setScene(scene);
    }

}
