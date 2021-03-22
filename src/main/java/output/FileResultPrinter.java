package main.java.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileResultPrinter implements ResultPrinter {
    BufferedWriter writer;

    public FileResultPrinter(BufferedWriter writer){
        this.writer=writer;
    }
    @Override
    public void printResult(int i, double x, double fx) {
        try {
            writer.write("Корень найден за " + i + " итераций" + "\n");
            writer.write("x: "+x+"\n");
            writer.write("f(x): "+fx+"\n");
            writer.flush();
        }catch (IOException e) {
            System.out.println("Не удалось записать в файл.\n\n" +
                    "Перезапустите программу в консольном режиме или укажите корректный путь к файлу.");
        }
    }
}
