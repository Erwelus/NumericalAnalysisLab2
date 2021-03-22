package main.java;

import main.java.functions.Function1;
import main.java.functions.Function2;
import main.java.functions.Function3;
import main.java.functions.Functional;
import main.java.input.*;
import main.java.methods.BinarySearchMethod;
import main.java.methods.IterationMethod;
import main.java.methods.Method;
import main.java.methods.SecantMethod;
import main.java.output.*;

import java.io.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    private static BufferedWriter readFileOut(Scanner scan){
        System.out.println("Введите имя файла для вывода данных");
        BufferedWriter bufferedWriter;
        while (true){
            try {
                if (scan.hasNext()) {
                    String filename = scan.next();
                    bufferedWriter = new BufferedWriter(new FileWriter(filename));
                    break;
                }
            }catch (IOException e) {
                System.out.println("Файл не найден. Проверьте корректность написания имени файла.");
            }
        }
        return bufferedWriter;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Greeter greeter = new Greeter(scan);
        DataHolder holder = new DataHolder();
        greeter.greet(holder);
        Functional func=null;
        switch (holder.getFuncNum()){
            case 1: {
                func = new Function1();
                break;
            }
            case 2: {
                func = new Function2();
                break;
            }
            case 3: {
                func = new Function3();
                break;
            }
        }

        DataReader reader;
        if (holder.getInFormat() ==1){
            System.out.println("Введите имя файла для ввода данных");
            BufferedReader bufferedReader;
            while (true){
                try {
                    if (scan.hasNext()) {
                        String filename = scan.next();
                        bufferedReader = new BufferedReader(new FileReader(filename));
                        break;
                    }
                }catch (FileNotFoundException e) {
                    System.out.println("Файл не найден. Проверьте корректность написания имени файла.");
                }
            }
            reader = new FileDataReader(bufferedReader, holder);
        }else{
            reader = new ConsoleDataReader(scan, holder);
        }
        reader.read();
        Validator validator = new Validator(holder, func);
        if(!validator.validate()){
            System.out.println("Введенные данные некорректны. Пожалуйста, перезапустите программу с корректными данными");
            System.exit(0);
        }

        DrawChart drawChart = new DrawChart();
        Method method=null;
        ResultPrinter resultPrinter=null;
        BufferedWriter writer=null;
        if (holder.getOutFormat() == 1){
            writer = readFileOut(scan);
            resultPrinter = new FileResultPrinter(writer);
        }else resultPrinter = new ConsoleResultPrinter();
        switch (holder.getMethodNum()){
            case 1: {
                PrinterBinarySearch printerBinarySearch;
                if (holder.getOutFormat() == 1){
                    printerBinarySearch = new FilePrinterBinarySearch(writer);
                }else{
                    printerBinarySearch = new ConsolePrinterBinarySearch();
                }
                method = new BinarySearchMethod(holder.getLeft(), holder.getRight(), holder.getE(), func, printerBinarySearch, drawChart);
                break;
            }
            case 4: {
                PrinterSecant printerSecant;
                if (holder.getOutFormat() == 1){
                    printerSecant = new FilePrinterSecant(writer);
                }else{
                    printerSecant = new ConsolePrinterSecant();
                }
                method = new SecantMethod(holder.getLeft(), holder.getRight(), holder.getX1(), holder.getE(), func, printerSecant, drawChart);
                break;
            }
            case 5: {
                PrinterIterations printerIterations;
                if (holder.getOutFormat() == 1){
                    printerIterations = new FilePrinterIterations(writer);
                }else{
                    printerIterations = new ConsolePrinterIterations();
                }
                method = new IterationMethod(holder.getLeft(), holder.getRight(), holder.getE(), func, printerIterations, drawChart);
                break;
            }
        }

        double result = method.count();
        if (holder.getMethodNum()==5 && method.getIterations()==0){
            System.out.println("Последовательность расходится");
        }else resultPrinter.printResult(method.getIterations(), result, func.count(result));
    }
}
