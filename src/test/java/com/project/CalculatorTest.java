package com.project;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Nested
    class AdditionTests {

        @Test
        void calculate_givenTwoPositiveNumbers_returnsCorrectSum() {
            Calculator calculator = new Calculator(2, 3, '+');

            double result = calculator.calculate();

            assertEquals(5.0, result);
        }

        @Test
        void calculate_givenPositiveAndNegativeNumber_returnsCorrectSum() {
            Calculator calculator = new Calculator(10, -3, '+');

            double result = calculator.calculate();

            assertEquals(7.0, result);
        }

        @Test
        void calculate_givenTwoNegativeNumbers_returnsCorrectSum() {
            Calculator calculator = new Calculator(-4, -6, '+');

            double result = calculator.calculate();

            assertEquals(-10.0, result);
        }

        @Test
        void calculate_givenZeroAndNumber_returnsSameNumber() {
            Calculator calculator = new Calculator(0, 5, '+');

            double result = calculator.calculate();

            assertEquals(5.0, result);
        }
    }

    @Nested
    class SubtractionTests {

        @Test
        void calculate_givenTwoPositiveNumbers_returnsCorrectDifference() {
            Calculator calculator = new Calculator(10, 3, '-');

            double result = calculator.calculate();

            assertEquals(7.0, result);
        }

        @Test
        void calculate_givenResultNegative_returnsNegativeDifference() {
            Calculator calculator = new Calculator(3, 10, '-');

            double result = calculator.calculate();

            assertEquals(-7.0, result);
        }

        @Test
        void calculate_givenSubtractingZero_returnsSameNumber() {
            Calculator calculator = new Calculator(5, 0, '-');

            double result = calculator.calculate();

            assertEquals(5.0, result);
        }
    }

    @Nested
    class MultiplicationTests {

        @Test
        void calculate_givenTwoPositiveNumbers_returnsCorrectProduct() {
            Calculator calculator = new Calculator(4, 5, '*');

            double result = calculator.calculate();

            assertEquals(20.0, result);
        }

        @Test
        void calculate_givenNumberAndZero_returnsZero() {
            Calculator calculator = new Calculator(123.45, 0, '*');

            double result = calculator.calculate();

            assertEquals(0.0, result);
        }

        @Test
        void calculate_givenPositiveAndNegativeNumbers_returnsNegativeProduct() {
            Calculator calculator = new Calculator(4, -2, '*');

            double result = calculator.calculate();

            assertEquals(-8.0, result);
        }

        @Test
        void calculate_givenTwoNegativeNumbers_returnsPositiveProduct() {
            Calculator calculator = new Calculator(-3, -3, '*');

            double result = calculator.calculate();

            assertEquals(9.0, result);
        }
    }

    @Nested
    class DivisionTests {

        @Test
        void calculate_givenTwoPositiveNumbers_returnsCorrectQuotient() {
            Calculator calculator = new Calculator(10, 2, '/');

            double result = calculator.calculate();

            assertEquals(5.0, result);
        }

        @Test
        void calculate_givenDivisionResultIsDecimal_returnsCorrectQuotient() {
            Calculator calculator = new Calculator(7, 2, '/');

            double result = calculator.calculate();

            assertEquals(3.5, result);
        }

        @Test
        void calculate_givenNegativeDividend_returnsNegativeQuotient() {
            Calculator calculator = new Calculator(-10, 2, '/');

            double result = calculator.calculate();

            assertEquals(-5.0, result);
        }

        @Test
        void calculate_givenNegativeDivisor_returnsNegativeQuotient() {
            Calculator calculator = new Calculator(10, -2, '/');

            double result = calculator.calculate();

            assertEquals(-5.0, result);
        }

        @Test
        void calculate_givenBothNegative_returnsPositiveQuotient() {
            Calculator calculator = new Calculator(-10, -2, '/');

            double result = calculator.calculate();

            assertEquals(5.0, result);
        }

        @Test
        void calculate_givenDivisionByZero_throwsArithmeticException() {
            Calculator calculator = new Calculator(10, 0, '/');

            assertThrows(ArithmeticException.class, calculator::calculate);
        }
    }


    @Nested
    class InvalidAndEdgeCasesTests {

        @Test
        void calculate_givenUnsupportedOperation_throwsIllegalArgumentException() {
            Calculator calculator = new Calculator(10, 5, '%');

            assertThrows(IllegalArgumentException.class, calculator::calculate);
        }

        @Test
        void calculate_givenAnotherUnsupportedOperation_throwsIllegalArgumentException() {
            Calculator calculator = new Calculator(10, 5, 'x');

            assertThrows(IllegalArgumentException.class, calculator::calculate);
        }

        @Test
        void calculate_givenVeryLargeNumbers_returnsInfinityOnOverflow() {
            Calculator calculator = new Calculator(Double.MAX_VALUE, 2, '*');

            double result = calculator.calculate();

            assertTrue(Double.isInfinite(result));
        }
    }
}