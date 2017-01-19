package ru.job4j;

public class Calculate {
    private double result;

    public Calculate() {
        this.result = result;
    }

    public void addSum(double first, double second) {
        this.result = first + second;
    }
    public void addSub(double first, double second) {
        this.result = first - second;
    }

    public void addDiv(double first, double second) {
        this.result = first / second;
    }

    public void addMul(double first, double second) {
        this.result = first * second;
    }
	 public double getResult() {
        return result;
    }
}
