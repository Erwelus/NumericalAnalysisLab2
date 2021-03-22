package main.java.output;

public class ConsolePrinterSecant implements PrinterSecant {
    @Override
    public void printIteration(int i, double prev, double cur, double next, double fnext) {
        System.out.println("Номер итерации: "+i);
        System.out.println("x[i-1]: "+prev);
        System.out.println("x[i]: "+cur);
        System.out.println("x[i+1]: "+next);
        System.out.println("f(x[i+1]): "+fnext);
        System.out.println("|x[i+1] - x[i]|: "+Math.abs(next - cur));
    }
}
