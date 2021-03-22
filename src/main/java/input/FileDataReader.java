package main.java.input;

import java.io.BufferedReader;
import java.io.IOException;

public class FileDataReader implements DataReader{
    private final DataHolder holder;
    private BufferedReader bufferedReader;

    public FileDataReader(BufferedReader bufferedReader, DataHolder holder){
        this.bufferedReader=bufferedReader;
        this.holder=holder;
    }

    @Override
    public void read() {
        try {
            String line = bufferedReader.readLine();
            String[] nums = line.split(" ");
            holder.setLeft(Double.parseDouble(nums[0]));
            holder.setRight(Double.parseDouble(nums[1]));
            holder.setE(Double.parseDouble(nums[2]));
            if (holder.getMethodNum() == 4){
                holder.setX1(Double.parseDouble(nums[3]));
            }
        }catch (IOException|NumberFormatException ex){
            System.out.println("Некорректный файл");
            System.exit(0);
        }
    }
}
