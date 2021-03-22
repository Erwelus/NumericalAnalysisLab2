package main.java.methods;

import main.java.functions.Functional;
import main.java.output.DrawChart;
import main.java.output.PrinterIterations;


public class IterationMethod implements Method {
    private final double a;
    private final double b;
    private final double e;
    private final Functional func;
    private final PrinterIterations printer;
    private int iterations=0;
    private double lambda;
    private DrawChart drawChart;

    public IterationMethod(double a, double b, double e, Functional func, PrinterIterations printer, DrawChart drawChart) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.func = func;
        this.printer=printer;
        this.drawChart=drawChart;
    }


    @Override
    public double count() {
        double res = a;
        setLambda();
        double prev;
        do {
            prev = res;
            res = countFi(prev);
            if (!checkConvergence(prev)){
                iterations=0;
                break;
            }
            printer.printIteration(++iterations, prev, res, countFi(res), func.count(res));
            if (res > b || res < a){
                iterations =0;
                break;
            }
        } while (Math.abs(res - prev) > e);
        drawChart.drawForSimpleIteration(a, b, lambda, func);
        return res;
    }

    @Override
    public int getIterations() {
        return iterations;
    }

    //calculating lambda as demanded in 3 way
    private void setLambda() {
        this.lambda = -1/Math.max(func.countFirstDerivative(a), func.countFirstDerivative(b));
    }

    private double countFi(double x){
        return x + lambda*func.count(x);
    }

    private boolean checkConvergence(double x){
        return 1 + lambda*func.countFirstDerivative(x) < 1;
    }
}
