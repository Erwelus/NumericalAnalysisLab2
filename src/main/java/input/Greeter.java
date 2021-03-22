package main.java.input;

import java.util.Scanner;

public class Greeter {
    private final Scanner scanner;


    public Greeter(Scanner scanner){
        this.scanner=scanner;
    }

    private int readNumber(int low, int high){
        int num;
        while (true){
            try {
                if (scanner.hasNext()) {
                    num = Integer.parseInt(scanner.next());
                    if (num <high && num >low){
                        break;
                    }else{
                        throw new Exception();
                    }
                }
            }catch (Exception e) {
                System.out.println("Пожалуйста, введите одно из предложенных чисел.");
            }
        }
        return num;
    }

    public void greet(DataHolder holder){
        System.out.println("Данная программа предназначена для нахождения корней уравнений.");
        System.out.println("Выберите уравнение, корень которого требуется вычислить:");
        System.out.println("[ 1 ]: x^(3) −3.125x^(2) −3.5x +2.458");
        System.out.println("[ 2 ]: 5x^(3) -x^(2) -20x +4");
        System.out.println("[ 3 ]: sin(x) + 0.5");

        holder.setFuncNum(readNumber(0, 4));

        System.out.println("Выберите численный метод:");
        System.out.println("[ 1 ]: Метод половинного деления");
        System.out.println("[ 4 ]: Метод секущих");
        System.out.println("[ 5 ]: Метод простых итераций");

        holder.setMethodNum(readNumber(0, 6));

        System.out.println("Выберите формат ввода данных:");
        System.out.println("Ввод из консоли: [ 0 ]");
        System.out.println("Ввод из файла: [ 1 ]");

        holder.setInFormat(readNumber(-1, 2));

        System.out.println("Выберите формат вывода данных:");
        System.out.println("Вывод в консоль: [ 0 ]");
        System.out.println("Вывод в файл: [ 1 ]");

        holder.setOutFormat(readNumber(-1, 2));
    }
}
