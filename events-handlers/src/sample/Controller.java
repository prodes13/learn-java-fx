package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private Button deleteButton;

    @FXML
    public void initialize() {
        okButton.setDisable(true);
        deleteButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(okButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(deleteButton)){
            nameField.setText("");
            disableButtons(true);
        }
    }

    public void disableButtons(boolean disableButtons) {
        okButton.setDisable(disableButtons);
        deleteButton.setDisable(disableButtons);
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() | text.trim().isEmpty();
        disableButtons(disableButtons);
    }

}
