package com.project;

import com.project.shapes.*;

public class Main {
    public static void main(String[] args) {

        // TASK 1

        IShape sphere = new Sphere(5);
        System.out.println("Sphere:");
        System.out.printf("Area: %.3f%n", sphere.calculateArea());
        System.out.printf("Volume: %.3f%n%n", sphere.calculateVolume());

        IShape cylinder = new Cylinder(3, 7);
        System.out.println("Cylinder:");
        System.out.printf("Area: %.3f%n", cylinder.calculateArea());
        System.out.printf("Volume: %.3f%n%n", cylinder.calculateVolume());

        IShape rectangle = new Rectangle(4, 8);
        System.out.println("Rectangle:");
        System.out.printf("Area: %.3f%n", rectangle.calculateArea());
        System.out.printf("Volume: %.3f%n%n", rectangle.calculateVolume());

        IShape cube = new Cube(4);
        System.out.println("Cube:");
        System.out.printf("Area: %.3f%n", cube.calculateArea());
        System.out.printf("Volume: %.3f%n", cube.calculateVolume());

        // TASK 2

        Calculator calc1 = new Calculator(10, 5, '+');
        System.out.println("10 + 5 = " + calc1.calculate());

        Calculator calc2 = new Calculator(10, 5, '-');
        System.out.println("10 - 5 = " + calc2.calculate());

        Calculator calc3 = new Calculator(10, 5, '*');
        System.out.println("10 * 5 = " + calc3.calculate());

        Calculator calc4 = new Calculator(10, 5, '/');
        System.out.println("10 / 5 = " + calc4.calculate());

        Calculator calc5 = new Calculator(7.5, 2.5, '/');
        System.out.println("7.5 / 2.5 = " + calc5.calculate());

        try {
            Calculator calc6 = new Calculator(10, 0, '/');
            System.out.println("10 / 0 = " + calc6.calculate());
        } catch (ArithmeticException ex) {
            System.out.println("Caught ArithmeticException: " + ex.getMessage());
        }

        try {
            Calculator unsupported = new Calculator(10, 5, '%');
            System.out.println("10 % 5 = " + unsupported.calculate());
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught IllegalArgumentException: " + ex.getMessage());
        }

    }
}