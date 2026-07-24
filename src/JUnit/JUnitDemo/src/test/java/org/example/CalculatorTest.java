package org.example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @BeforeAll
    static void start() {
        System.out.println("Application Started");
    }

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2,3));
    }

    @Test
    void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.subtract(5,3));
    }

    @Test
    void testMultiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2,3));
    }
    @Test
    void testDivide() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(10,5));
    }

    @Test
    void testDivideByZero() {

        Calculator calc = new Calculator();

        assertThrows(
                ArithmeticException.class,
                () -> calc.divide(10,0)
        );
    }
}