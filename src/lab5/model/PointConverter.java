package lab5.model;

import java.text.DecimalFormat;

public class PointConverter {
    private String x;
    private String y;
    private String alpha;
    private String beta;
    private String a;
    private String b;
    private String c;
    private String L;
    private String K;
    private String f;

    public PointConverter(double x, double alpha, double beta, double a, double b, double c,
                          double f, double L, double K, double y) {
        String pattern = "##0.0000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        this.setX(decimalFormat.format(x));
        this.setAlpha(decimalFormat.format(alpha));
        this.setBeta(decimalFormat.format(beta));
        this.setA(decimalFormat.format(a));
        this.setB(decimalFormat.format(b));
        this.setC(decimalFormat.format(c));
        this.setF(decimalFormat.format(f));
        this.setL(decimalFormat.format(L));
        this.setK(decimalFormat.format(K));
        this.setY(decimalFormat.format(y));
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getBeta() {
        return beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getL() {
        return L;
    }

    public void setL(String l) {
        L = l;
    }

    public String getK() {
        return K;
    }

    public void setK(String k) {
        K = k;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
}
