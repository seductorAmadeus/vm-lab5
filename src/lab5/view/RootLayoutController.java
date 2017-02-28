package lab5.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lab5.MainApp;
import lab5.model.BoundaryValueProblemSolver;
import lab5.model.PointConverter;
import lab5.model.data.InputData;
import lab5.model.data.OutputData;

public class RootLayoutController {

    private ObservableList points = FXCollections.observableArrayList();

    @FXML
    private TextField numberOfGridPoints;
    @FXML
    private TextField initialIntervalValueField;
    @FXML
    private TextField finalIntervalValueField;
    @FXML
    private TableView<Double> pointsTable;
    @FXML
    private TableColumn<PointConverter, String> xColumn;
    @FXML
    private TableColumn<PointConverter, String> alphaColumn;
    @FXML
    private TableColumn<PointConverter, String> betaColumn;
    @FXML
    private TableColumn<PointConverter, String> aColumn;
    @FXML
    private TableColumn<PointConverter, String> bColumn;
    @FXML
    private TableColumn<PointConverter, String> cColumn;
    @FXML
    private TableColumn<PointConverter, String> fColumn;
    @FXML
    private TableColumn<PointConverter, String> yColumn;
    @FXML
    private TableColumn<PointConverter, String> sweepRateLColumn;
    @FXML
    private TableColumn<PointConverter, String> sweepRateKColumn;
    @FXML
    private TextField yInitialValueField;
    @FXML
    private TextField yFinalValueField;

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

    private boolean isDoubleValue(String value) {
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

        if (numberOfGridPoints.getText() == null || numberOfGridPoints.getText().length() == 0 || !isDoubleValue(numberOfGridPoints.getText())) {
            errorMessage.append("Некорректное число узлов сетки!\n");
        }

        if (initialIntervalValueField.getText() == null || initialIntervalValueField.getText().length() == 0 || !isDoubleValue(initialIntervalValueField.getText())) {
            errorMessage.append("Некорректное начальное значение интервала!\n");
        }

        if (finalIntervalValueField.getText() == null || finalIntervalValueField.getText().length() == 0 || !isDoubleValue(finalIntervalValueField.getText())) {
            errorMessage.append("Некорректное конечное значение интервала!\n");
        }

        if (isDoubleValue(finalIntervalValueField.getText()) && isDoubleValue(initialIntervalValueField.getText())) {
            if (Double.valueOf(finalIntervalValueField.getText()) < Double.valueOf(initialIntervalValueField.getText())) {
                errorMessage.append("Конечное значение интервала должно быть > начального значения!\n");
            }
        }

        if (yInitialValueField.getText() == null || yInitialValueField.getText().length() == 0 || !isDoubleValue(yInitialValueField.getText())) {
            errorMessage.append("Некорректное начальное значение y!\n");
        }

        if (yFinalValueField.getText() == null || yFinalValueField.getText().length() == 0 || !isDoubleValue(yFinalValueField.getText())) {
            errorMessage.append("Некорректное конечное значение y!\n");
        }

        if (isDoubleValue(yInitialValueField.getText()) && isDoubleValue(yFinalValueField.getText())) {
            if (Double.valueOf(yFinalValueField.getText()) < Double.valueOf(yInitialValueField.getText())) {
                errorMessage.append("Конечное значение y должно быть > начального значения y!\n");
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Пожалуйста, исправьте некорректные данные!");
            alert.setContentText(errorMessage.toString());

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    public void solveBoundaryValueProblem() {
        if (isInputValid()) {
            pointsTable.getItems().clear();

            InputData inputData = new InputData(Integer.valueOf(numberOfGridPoints.getText()),
                    Double.valueOf(initialIntervalValueField.getText()), Double.valueOf(finalIntervalValueField.getText()),
                    Double.valueOf(yInitialValueField.getText()), Double.valueOf(yFinalValueField.getText()));

            OutputData outputData = BoundaryValueProblemSolver.solve(inputData);

            xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
            alphaColumn.setCellValueFactory(new PropertyValueFactory<>("alpha"));
            betaColumn.setCellValueFactory(new PropertyValueFactory<>("beta"));
            aColumn.setCellValueFactory(new PropertyValueFactory<>("a"));
            bColumn.setCellValueFactory(new PropertyValueFactory<>("b"));
            cColumn.setCellValueFactory(new PropertyValueFactory<>("c"));
            fColumn.setCellValueFactory(new PropertyValueFactory<>("f"));
            sweepRateLColumn.setCellValueFactory(new PropertyValueFactory<>("L"));
            sweepRateKColumn.setCellValueFactory(new PropertyValueFactory<>("K"));
            yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

            for (int i = 0; i < outputData.getX().length && i < outputData.getA().length && i < outputData.getY().length
                    && i < outputData.getAlpha().length && i < outputData.getSweepRateL().length; i++) {
                points.add(new PointConverter((outputData.getX()[i]), outputData.getAlpha()[i], outputData.getBeta()[i],
                        outputData.getA()[i], outputData.getB()[i], outputData.getC()[i], outputData.getF()[i],
                        outputData.getSweepRateL()[i], outputData.getSweepRateK()[i], outputData.getY()[i]));
            }
            pointsTable.setItems(points);
        }
    }

    @FXML
    public void clearAllFields() {
        finalIntervalValueField.setText("");
        numberOfGridPoints.setText("");
        initialIntervalValueField.setText("");
        yFinalValueField.setText("");
        yInitialValueField.setText("");
        pointsTable.getItems().clear();
    }
}
