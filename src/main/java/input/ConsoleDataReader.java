package main.java.input;

import java.util.Scanner;

public class ConsoleDataReader implements DataReader {
    private Scanner scanner;
    private DataHolder holder;

    public ConsoleDataReader(Scanner scanner, DataHolder holder){
        this.scanner=scanner;
        this.holder=holder;
    }

    private double readNum(){
        double num;
        while (true){
            try {
                if (scanner.hasNext()) {
                    num = Double.parseDouble(scanner.next());
                    break;
                }
            }catch (Exception ex){
                System.out.println("Некорректный ввод. Следуйте указаниям.");
            }
        }
        return num;
    }


    @Override
    public void read() {
        System.out.println("Пожалуйста, введите левую границу интервала");
        holder.setLeft(readNum());
        System.out.println("Пожалуйста, введите правую границу интервала");
        holder.setRight(readNum());
        System.out.println("Пожалуйста, введите точность");
        holder.setE(readNum());
        if (holder.getMethodNum() == 4){
            System.out.println("Пожалуйста, введите приближение x1, лежащее внутри интервала");
            holder.setX1(readNum());
        }
    }
}
