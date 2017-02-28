package lab5.model.data;

public class InputData {

    private int numberGridPoints;
    private double finalIntervalValue;
    private double initialIntervalValue;
    private double yInitialValue;
    private double yFinalValue;

    public InputData(int numberGridPoints,
                     double initialIntervalValue, double finalIntervalValue, double yInitialValue, double yFinalValue) {
        this.numberGridPoints = numberGridPoints;
        this.initialIntervalValue = initialIntervalValue;
        this.finalIntervalValue = finalIntervalValue;
        this.yInitialValue = yInitialValue;
        this.yFinalValue = yFinalValue;
    }

    public int getNumberOfGridPoints() {
        return numberGridPoints;
    }

    public double getFinalIntervalValue() {
        return finalIntervalValue;
    }

    public double getInitialIntervalValue() {
        return initialIntervalValue;
    }

    public double getyInitialValue() {
        return yInitialValue;
    }

    public double getyFinalValue() {
        return yFinalValue;
    }
}
