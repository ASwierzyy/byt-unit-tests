package com.project;

import com.project.shapes.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapesTest {

    private final double ACCEPTABLE_RANGE = 1e-6;

    @Nested
    class SphereTests {

        @Test
        void calculateArea_givenSphereRadius5_returnExpectedArea(){
            IShape sphere = new Sphere(5);

            double result = sphere.calculateArea();

            double expected = 4 * Math.PI * Math.pow(5, 2);
            assertEquals(expected, result, ACCEPTABLE_RANGE);
        }

        @Test
        void calculateVolume_givenSphereRadius5_returnsExpectedVolume() {
            IShape sphere = new Sphere(5);

            double result = sphere.calculateVolume();

            double expected = (4.0 / 3.0) * Math.PI * Math.pow(5, 3);
            assertEquals(expected, result, ACCEPTABLE_RANGE);
        }

        @Test
        void calculateArea_givenSphereRadiusZero_returnsZero() {
            IShape sphere = new Sphere(0);

            double result = sphere.calculateArea();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateVolume_givenSphereRadiusZero_returnsZero() {
            IShape sphere = new Sphere(0);

            double result = sphere.calculateVolume();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void constructor_givenNegativeRadius_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Sphere(-2)
            );
        }
    }

    @Nested
    class CylinderTests {

        @Test
        void calculateArea_givenRadius3Height7_returnsExpectedArea() {
            IShape cylinder = new Cylinder(3, 7);

            double result = cylinder.calculateArea();

            double expected = 2 * Math.PI * 3 * (3 + 7);
            assertEquals(expected, result, ACCEPTABLE_RANGE);
        }

        @Test
        void calculateVolume_givenRadius3Height7_returnsExpectedVolume() {
            IShape cylinder = new Cylinder(3, 7);

            double result = cylinder.calculateVolume();

            double expected = Math.PI * Math.pow(3, 2) * 7;
            assertEquals(expected, result, ACCEPTABLE_RANGE);
        }

        @Test
        void calculateArea_givenZeroRadiusPositiveHeight_returnsZeroArea() {
            IShape cylinder = new Cylinder(0, 10);

            double result = cylinder.calculateArea();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateVolume_givenZeroRadiusPositiveHeight_returnsZeroVolume() {
            IShape cylinder = new Cylinder(0, 10);

            double result = cylinder.calculateVolume();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateArea_givenPositiveRadiusZeroHeight_returnsAreaOfTwoBases() {
            double radius = 4;
            IShape cylinder = new Cylinder(radius, 0);

            double result = cylinder.calculateArea();

            double expected = 2 * Math.PI * radius * radius;
            assertEquals(expected, result, ACCEPTABLE_RANGE);
        }

        @Test
        void calculateVolume_givenPositiveRadiusZeroHeight_returnsZeroVolume() {
            IShape cylinder = new Cylinder(4, 0);

            double result = cylinder.calculateVolume();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void constructor_givenNegativeRadius_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder(-1, 5)
            );
        }

        @Test
        void constructor_givenNegativeHeight_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder(2, -3)
            );
        }
    }

    @Nested
    class RectangleTests {

        @Test
        void calculateArea_givenLength4Width8_returnsExpectedArea() {
            IShape rectangle = new Rectangle(4, 8);

            double result = rectangle.calculateArea();

            double expected = 32.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateVolume_given2DShape_returnsZero() {
            IShape rectangle = new Rectangle(4, 8);

            double result = rectangle.calculateVolume();

            assertEquals(0.0, result);
        }

        @Test
        void calculateArea_givenZeroLengthPositiveWidth_returnsZero() {
            IShape rectangle = new Rectangle(0, 5);

            double result = rectangle.calculateArea();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateArea_givenPositiveLengthZeroWidth_returnsZero() {
            IShape rectangle = new Rectangle(7, 0);

            double result = rectangle.calculateArea();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void constructor_givenNegativeLength_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Rectangle(-3, 4)
            );
        }

        @Test
        void constructor_givenNegativeWidth_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Rectangle(3, -4)
            );
        }
    }

    @Nested
    class CubeTests {

        @Test
        void calculateArea_givenSide4_returnsExpectedArea() {
            IShape cube = new Cube(4);

            double result = cube.calculateArea();

            double expected = 6 * Math.pow(4, 2);
            assertEquals(expected, result);
        }

        @Test
        void calculateVolume_givenSide4_returnsExpectedVolume() {
            IShape cube = new Cube(4);

            double result = cube.calculateVolume();

            double expected = Math.pow(4, 3);
            assertEquals(expected, result);
        }

        @Test
        void calculateArea_givenSideZero_returnsZero() {
            IShape cube = new Cube(0);

            double result = cube.calculateArea();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void calculateVolume_givenSideZero_returnsZero() {
            IShape cube = new Cube(0);

            double result = cube.calculateVolume();

            double expected = 0.0;
            assertEquals(expected, result);
        }

        @Test
        void constructor_givenNegativeSide_throwsIllegalArgumentException() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cube(-2)
            );
        }
    }
}
