package main.java.functions;

public class Function3 implements Functional {//sin(x) +0.5
    private final double root = Math.PI + Math.PI/6;
    @Override
    public boolean checkRoot(double left, double right) {
        double diff = right - left;
        if (diff > 2*Math.PI){
            return false;
        }
        return count(left)*count(right) < 0;
    }

    @Override
    public double count(double x) {
        return Math.sin(x) + 0.5;
    }

    @Override
    public double countFirstDerivative(double x) {
        return Math.cos(x);
    }

    @Override
    public double countSecondDerivative(double x) {
        return -Math.sin(x);
    }
}
