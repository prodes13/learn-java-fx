package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField nameField;

    @FXML
    public void onButtonClicked(ActionEvent e) {
        System.out.println("Hello, " + nameField.getText());
        System.out.println("The button was pressed - " + e.getSource());
    }

    @FXML
    public void deleteText() {
        nameField.setText("");
    }
}
