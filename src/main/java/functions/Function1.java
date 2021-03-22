package main.java.functions;

public class Function1 implements Functional {//x^3−3.125x^2−3.5x+2.458

    final double[] roots = {-1.2496735296975, 0.50878726884896, 3.8658862612079};

    @Override
    public boolean checkRoot(double left, double right) {
        return count(left)*count(right) < 0 && countFirstDerivative(left)*countFirstDerivative(right) >= 0;
    }

    @Override
    public double count(double x) {
        return Math.pow(x, 3) - 3.125*Math.pow(x, 2) - 3.5*x + 2.458;
    }

    @Override
    public double countFirstDerivative(double x) {
        return 3*Math.pow(x, 2) - 6.25*x - 3.5;
    }

    @Override
    public double countSecondDerivative(double x) {
        return 6*x - 6.25;
    }

}
