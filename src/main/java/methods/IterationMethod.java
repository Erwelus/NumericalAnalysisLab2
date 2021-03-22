package main.java.methods;

import com.sun.scenario.effect.impl.state.AccessHelper;
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
    private double q;

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
        countQ();
        double prev;
        if ((q>=1)||(Math.abs(countFiDerivative(a))>q)||(Math.abs(countFiDerivative(b))>q)||(Math.abs(countFiDerivative((a+b)/2))>q)) {
            return -1;
        }
        do {
            prev = res;
            res = countFi(prev);
            printer.printIteration(++iterations, prev, res, countFi(res), func.count(res));
        } while (check(res, prev));
        drawChart.draw(a, b, func);
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
        return countFiDerivative(x) < 1;
    }

    private double countFiDerivative(double x){
        return 1 + lambda*func.countFirstDerivative(x);
    }

    private void countQ(){
        q = Math.max(Math.abs(countFiDerivative(a)), Math.abs(countFiDerivative(b)));
    }

    private boolean check(double res, double prev){
        if (!checkQ()){
            return Math.abs(res - prev) > e;
        }else{
            return Math.abs(res - prev) > e*(1-q)/q;
        }
    }

    private boolean checkQ(){
        return q > 0.5;
    }
}
