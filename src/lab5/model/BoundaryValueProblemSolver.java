package lab5.model;

import lab5.model.data.InputData;
import lab5.model.data.OutputData;

public class BoundaryValueProblemSolver {

    public static OutputData solve(InputData inputData) {
        double h;
        double initialIntervalValue = inputData.getInitialIntervalValue();
        double finalIntervalValue = inputData.getFinalIntervalValue();
        int numberOfGridPoints = inputData.getNumberOfGridPoints();
        double[] sweepRateL = new double[numberOfGridPoints];
        double[] sweepRateK = new double[numberOfGridPoints];
        double[] y = new double[numberOfGridPoints + 1];
        double[] x = new double[numberOfGridPoints + 1];
        double[] alpha = new double[numberOfGridPoints];
        double[] beta = new double[numberOfGridPoints];
        double[] a = new double[numberOfGridPoints];
        double[] b = new double[numberOfGridPoints];
        double[] c = new double[numberOfGridPoints];
        double[] f = new double[numberOfGridPoints];

        h = (finalIntervalValue - initialIntervalValue) / numberOfGridPoints;

        // fill in the x, increasing each step
        x[0] = finalIntervalValue;
        for (int i = 1; i < numberOfGridPoints + 1; i++) {
            x[i] = h + x[i - 1];
        }
        // fill an array of alpha
        for (int i = 0; i < numberOfGridPoints; i++) {
            alpha[i] = getAlpha(x[i]);
        }
        // fill an array of beta
        for (int i = 0; i < numberOfGridPoints; i++) {
            beta[i] = getBeta(x[i]);
        }
        // calculate coefficients columns
        for (int i = 0; i < numberOfGridPoints; i++) {
            a[i] = 2 - alpha[i] * h;
            b[i] = 2 * h * h * beta[i] - 4;
            c[i] = 2 + alpha[i] * h;
            f[i] = 2 * h * h * x[i];
        }

        // forward sweep
        sweepRateL[0] = 0;
        for (int i = 1; i < numberOfGridPoints; i++) {
            sweepRateL[i] = (-c[i]) / (b[i] + a[i] * sweepRateL[i - 1]);
        }
        sweepRateK[0] = inputData.getyInitialValue();
        for (int i = 1; i < numberOfGridPoints; i++) {
            sweepRateK[i] = ((f[i]) - a[i] * sweepRateK[i - 1]) / (b[i] + a[i] * sweepRateL[i - 1]);
        }

        // reverse sweep
        // y[0] = inputData.getyInitialValue();
        y[numberOfGridPoints] = inputData.getyFinalValue();

        for (int i = numberOfGridPoints - 1; (i > initialIntervalValue) && (i >= 0); i--) {
            y[i] = sweepRateL[i] * y[i + 1] + sweepRateK[i];
        }

        return new OutputData(x, alpha, beta, a, b, c,
                f, sweepRateL, sweepRateK, y);
    }

    private static double getAlpha(double x) {
        return -2 / x;
    }

    private static double getBeta(double x) {
        return 2 / (x * x);
    }
}
