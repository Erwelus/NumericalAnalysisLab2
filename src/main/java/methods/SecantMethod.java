package main.java.methods;

import main.java.functions.Functional;
import main.java.output.DrawChart;
import main.java.output.PrinterSecant;

public class SecantMethod implements Method {
    private double a;
    private double b;
    private final double e;
    private Functional func;
    private PrinterSecant printer;
    private DrawChart drawChart;

    private double prev;
    private double cur;
    private int iterations=0;

    public SecantMethod(double a, double b, double second, double e, Functional func, PrinterSecant printer, DrawChart drawChart){
        this.a = a;
        this.b = b;
        this.cur = second;
        this.e = e;
        this.func = func;
        this.printer=printer;
        this.drawChart = drawChart;
        setFirst();
    }

    private void setFirst(){
        if (func.count(b)*func.countSecondDerivative(b) > 0){
            prev = b;
        }else prev = a;
    }

    private double countNext(){
        return cur - ((cur-prev)/(func.count(cur) - func.count(prev)))* func.count(cur);
    }

    @Override
    public double count() {
        while( (Math.abs(func.count(cur)) > e) || (Math.abs(cur - prev) > e) ){
            double next = countNext();
            printer.printIteration(++iterations, prev, cur, next, func.count(next));
            prev = cur;
            cur = next;
        }
        drawChart.draw(a, b, func);
        return cur;
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
