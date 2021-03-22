package main.java.input;

public class DataHolder {
    private int funcNum;
    private int methodNum;
    private int inFormat;
    private int outFormat;
    private double left;
    private double right;
    private double x0;
    private double x1;
    private double e;

    public double getLeft() {
        return left;
    }
    public double getRight() {
        return right;
    }
    public double getX0() {
        return x0;
    }
    public double getX1() {
        return x1;
    }
    public int getInFormat() {
        return inFormat;
    }
    public int getOutFormat() {
        return outFormat;
    }
    public int getFuncNum() {
        return funcNum;
    }
    public int getMethodNum() {
        return methodNum;
    }
    public void setInFormat(int inFormat) {
        this.inFormat = inFormat;
    }
    public void setOutFormat(int outFormat) {
        this.outFormat = outFormat;
    }
    public void setFuncNum(int funcNum) {
        this.funcNum = funcNum;
    }
    public void setLeft(double left) {
        this.left = left;
    }
    public void setMethodNum(int methodNum) {
        this.methodNum = methodNum;
    }
    public void setRight(double right) {
        this.right = right;
    }
    public void setX0(double x0) {
        this.x0 = x0;
    }
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public double getE() {
        return e;
    }
    public void setE(double e) {
        this.e = e;
    }
}