
package zw.co.englishlearningsystem;

import javafx.scene.control.Alert;

public class Alerts {
        public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
