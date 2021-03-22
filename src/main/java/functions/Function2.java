package main.java.functions;

public class Function2 implements Functional{//5x^(3)-x^(2)-20x+4
    final double[] roots = {-2, 0.2, 2};

    @Override
    public boolean checkRoot(double left, double right) {
        return count(left)*count(right) < 0 && countFirstDerivative(left)*countFirstDerivative(right) >= 0;

    }

    @Override
    public double count(double x) {
        return 5*Math.pow(x, 3) - Math.pow(x, 2) - 20*x + 4;
    }

    @Override
    public double countFirstDerivative(double x) {
        return 15*Math.pow(x, 2) - 2*x - 20;
    }

    @Override
    public double countSecondDerivative(double x) {
        return 30*x - 2;
    }
}
