package com.project.shapes;

public class Cube implements IShape {

    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 6 * Math.pow(side, 2);
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }

}
