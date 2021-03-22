package main.java.input;

import main.java.functions.Functional;

public class Validator {
    private final DataHolder holder;
    private final Functional function;

    public Validator(DataHolder holder, Functional function){
        this.holder=holder;
        this.function = function;
    }

    public boolean validate(){
        if (holder.getMethodNum()>1 && holder.getMethodNum() < 4){
            return false;
        }
        if (holder.getRight() <= holder.getLeft()){
            return false;
        }
        if (holder.getFuncNum()==4 && (holder.getLeft() > holder.getX1() || holder.getX1() > holder.getRight())){
            return false;
        }
        return function.checkRoot(holder.getLeft(), holder.getRight());
    }
}
