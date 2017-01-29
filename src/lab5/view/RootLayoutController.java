package lab5.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab5.MainApp;

public class RootLayoutController {

    @FXML
    private TextField initialStepField;
    @FXML
    private TextField initialConditionField;
    @FXML
    private TextField accuracyField;
    @FXML
    private TextField initialIntervalValueField;
    @FXML
    private TextField finalIntervalValueField;
    @FXML
    private TableView<Double> pointsTable;
    @FXML
    private TableColumn<String, Double> firstNameColumn;
    @FXML
    private TableColumn<String, Double> lastNameColumn;

    private MainApp mainApp;
    private Stage mainStage;

    public RootLayoutController() {
    }

    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private boolean isValue(String value) {
        try {
            Double.valueOf(value);
            return true;
        } catch (NumberFormatException e) {
            e.getMessage();
            return false;
        }
    }

    private boolean isInputValid() {
        StringBuilder errorMessage = new StringBuilder();

        if (accuracyField.getText() == null || accuracyField.getText().length() == 0 || !isValue(accuracyField.getText())) {
            errorMessage.append("No valid accuracy!\n");
        }

        if (initialStepField.getText() == null || initialStepField.getText().length() == 0 || !isValue(initialStepField.getText())) {
            errorMessage.append("No valid initial step field!\n");
        }

        if (initialIntervalValueField.getText() == null || initialIntervalValueField.getText().length() == 0 || !isValue(initialIntervalValueField.getText())) {
            errorMessage.append("No valid initial interval value!\n");
        }

        if (finalIntervalValueField.getText() == null || finalIntervalValueField.getText().length() == 0 || !isValue(finalIntervalValueField.getText())) {
            errorMessage.append("No valid final interval value!\n");
        }

        if (initialConditionField.getText() == null || initialConditionField.getText().length() == 0 || !isValue(initialConditionField.getText())) {
            errorMessage.append("No valid initial conditional field!\n");
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("Invalid fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage.toString());

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    public void solveBoundaryValueProblem() {
        if (isInputValid()) {

        }
    }

    @FXML
    public void clearAllFields() {
        finalIntervalValueField.setText("");
        accuracyField.setText("");
        initialConditionField.setText("");
        initialStepField.setText("");
        initialIntervalValueField.setText("");
    }
}
