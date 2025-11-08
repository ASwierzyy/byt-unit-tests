package com.project;

public class Calculator {

    private final double a;
    private final double b;
    private final char operation;

    public Calculator(double a, double b, char operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public double calculate() {
        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0.0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };
    }

}
