package lab5.model.data;

public class OutputData {
    private double[] x;
    private double[] y;
    private double[] alpha;
    private double[] beta;
    private double[] a;
    private double[] b;
    private double[] c;
    private double[] f;
    private double[] sweepRateL;
    private double[] sweepRateK;

    public OutputData(double[] x, double[] alpha, double[] beta, double[] a, double[] b, double[] c,
                      double[] f, double[] sweepRateL, double[] sweepRateK, double[] y) {
        this.x = x.clone();
        this.alpha = alpha.clone();
        this.beta = beta.clone();
        this.a = a.clone();
        this.b = b.clone();
        this.c = c.clone();
        this.f = f.clone();
        this.sweepRateL = sweepRateL.clone();
        this.sweepRateK = sweepRateK.clone();
        this.y = y.clone();
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public double[] getAlpha() {
        return alpha;
    }

    public double[] getBeta() {
        return beta;
    }

    public double[] getA() {
        return a;
    }

    public double[] getB() {
        return b;
    }

    public double[] getC() {
        return c;
    }

    public double[] getSweepRateL() {
        return sweepRateL;
    }

    public double[] getSweepRateK() {
        return sweepRateK;
    }

    public double[] getF() {
        return f;
    }
}
