package main.java.methods;

import main.java.functions.Functional;
import main.java.output.DrawChart;
import main.java.output.PrinterBinarySearch;

public class BinarySearchMethod implements Method{
    private double a;
    private double b;
    private final double e;
    private Functional func;
    private PrinterBinarySearch printer;
    private int iterations=0;
    private DrawChart drawChart;

    public BinarySearchMethod(double a, double b, double e, Functional func, PrinterBinarySearch printer, DrawChart drawChart){
        this.a = a;
        this.b = b;
        this.e = e;
        this.func = func;
        this.printer=printer;
        this.drawChart = drawChart;
    }

    private int sign(double x) {
        if (x > 0)
            return 1;
        else if (x < 0)
            return -1;
        return 0;
    }

    @Override
    public double count() {
        double answer = -1;

        while ( (b - a) > e) {
            double x = (a + b) / 2;

            if (Math.abs(func.count(x))<= e){
                answer = x;
                break;
            }


            if (sign(func.count(a)) != sign(func.count(x))){
                b = x;
            }else if (sign(func.count(x)) != sign(func.count(b))){
                a = x;
            }
            printer.printIteration(++iterations, a, b, x, func.count(a), func.count(b), func.count(x));
            answer = x;

        }
        drawChart.draw(a, b, func);
        return answer;
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
