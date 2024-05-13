
package zw.co.englishlearningsystem;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowQuiz {
    
     public void showVocabularyQuizMenu(Stage primaryStage, User user) {
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
}
