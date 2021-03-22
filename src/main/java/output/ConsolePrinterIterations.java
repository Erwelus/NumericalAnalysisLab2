package main.java.output;

public class ConsolePrinterIterations implements PrinterIterations{
    @Override
    public void printIteration(int i, double x, double next, double finext, double fnext) {
        System.out.println("Номер итерации: "+i);
        System.out.println("x[i]: "+x);
        System.out.println("x[i+1]: "+next);
        System.out.println("fi(x[i+1): "+finext);
        System.out.println("f(x[i+1]): "+fnext);
        System.out.println("|x[i+1] - x[i]|: "+Math.abs(next - x)+"\n");
    }
}
