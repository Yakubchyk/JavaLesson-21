package com.calculator.model;

public class Operation {
    private double num1;
    private double num2;
    private String type;
    private double result;

    public Operation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Operation(double num1, double num2, String type, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public String getType() {
        return type;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
