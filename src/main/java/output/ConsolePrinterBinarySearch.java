package main.java.output;

public class ConsolePrinterBinarySearch implements PrinterBinarySearch {
    @Override
    public void printIteration(int i, double a, double b, double x, double fa, double fb, double fx) {
        System.out.println("Номер итерации: "+i);
        System.out.println("Левая граница промежутка: "+a);
        System.out.println("Правая граница промежутка: "+b);
        System.out.println("x: "+x);
        System.out.println("f(a): "+fa);
        System.out.println("f(b): "+fb);
        System.out.println("f(x): "+fx);
        System.out.println("|a - b|: "+(b-a)+"\n");
    }
}
