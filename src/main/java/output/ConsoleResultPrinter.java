package main.java.output;

public class ConsoleResultPrinter implements ResultPrinter {
    @Override
    public void printResult(int i, double x, double fx) {
        System.out.println("Корень найден за "+i+" итераций");
        System.out.println("x: "+x);
        System.out.println("f(x): "+fx+"\n");
    }
}
