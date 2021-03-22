package main.java.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class FilePrinterBinarySearch implements PrinterBinarySearch {
    BufferedWriter writer;

    public FilePrinterBinarySearch(BufferedWriter writer){
        this.writer=writer;
    }

    @Override
    public void printIteration(int i, double a, double b, double x, double fa, double fb, double fx) {
        try {
            writer.write("Номер итерации: "+i+"\n");
            writer.write("Левая граница промежутка: "+a+"\n");
            writer.write("Правая граница промежутка: "+b+"\n");
            writer.write("x: "+x+"\n");
            writer.write("f(a): "+fa+"\n");
            writer.write("f(b): "+fb+"\n");
            writer.write("f(x): "+fx+"\n");
            writer.write("|a - b|: "+(b-a)+"\n\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл.\n" +
                    "Перезапустите программу в консольном режиме или укажите корректный путь к файлу.");
        }
    }
}
