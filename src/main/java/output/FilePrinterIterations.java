package main.java.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class FilePrinterIterations implements PrinterIterations{
    BufferedWriter writer;

    public FilePrinterIterations(BufferedWriter writer){
        this.writer=writer;
    }

    @Override
    public void printIteration(int i, double x, double next, double finext, double fnext) {
        try {
            writer.write("Номер итерации: "+i+"\n");
            writer.write("x[i]: "+x+"\n");
            writer.write("x: "+x+"\n");
            writer.write("x[i+1]: "+next+"\n");
            writer.write("fi(x[i+1): "+finext+"\n");
            writer.write("f(x[i+1]): "+fnext+"\n");
            writer.write("|x[i+1] - x[i]|: "+Math.abs(next - x)+"\n\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл.\n" +
                    "Перезапустите программу в консольном режиме или укажите корректный путь к файлу.");
        }
    }
}
