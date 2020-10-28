package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private Button deleteButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

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
//            nameField.setText("");
            disableButtons(true);
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("Going to sleep - " + s);
                    Thread.sleep(5000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Going to run - " + s);
                            ourLabel.setText(nameField.getText());
                        }
                    });
                } catch(InterruptedException event) {
//            we don't care about this
                }
            }
        };

        new Thread(task).start();


        if(ourCheckBox.isSelected()) {
            nameField.clear();
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

    @FXML
    public void handleChange() {
        System.out.println("CheckBox is " + (ourCheckBox.isSelected() ? "checked!" : "not checked!"));
    }

}
