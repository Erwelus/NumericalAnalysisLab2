package main.java.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class FilePrinterSecant implements PrinterSecant {
    BufferedWriter writer;

    public FilePrinterSecant(BufferedWriter writer){
        this.writer=writer;
    }

    @Override
    public void printIteration(int i, double prev, double cur, double next, double fnext) {
        try {
            writer.write("Номер итерации: "+i+"\n");
            writer.write("x[i-1]: "+prev+"\n");
            writer.write("x[i]: "+cur+"\n");
            writer.write("x[i+1]: "+next+"\n");
            writer.write("f(x[i+1]): "+fnext+"\n");
            writer.write("|x[i+1] - x[i]|: "+Math.abs(next - cur)+"\n\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл.\n" +
                    "Перезапустите программу в консольном режиме или укажите корректный путь к файлу.");
        }
    }
}
