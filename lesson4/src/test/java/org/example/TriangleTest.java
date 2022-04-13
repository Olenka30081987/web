package org.example;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest{

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"15,6,10,20.123","10,6,5,11.399","8,9,8,29.765"})
    void testTriangleArea(int a, int b, int c, double result) throws MyNegativeNumberException, MyZeroNumberException, MyTriangleDoesNotExistException {
        logger.info("Тест testTriangleArea запущен");
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result,triangle.triangleArea(a,b,c));
        logger.info("Тест testTriangleArea завершен");
    }

    @Test
    void testCheckingForZero() throws MyNegativeNumberException, MyZeroNumberException, MyTriangleDoesNotExistException {
        logger.info("Тест testCheckingForZero запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyZeroNumberException.class,()-> triangle.triangleArea(0,20,15));
        logger.info("Тест testCheckingForZero завершен");
    }

    @Test
    void testCheckingForNegativeNumber() throws MyNegativeNumberException, MyZeroNumberException, MyTriangleDoesNotExistException {
        logger.info("Тест testCheckingForNegativeNumber запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyNegativeNumberException.class,()-> triangle.triangleArea(-10,15,20));
        logger.info("Тест testCheckingForNegativeNumber завершен");
    }

    @Test
    void testCheckingForTriangle() throws MyNegativeNumberException, MyZeroNumberException, MyTriangleDoesNotExistException {
        logger.info("Тест testCheckingForTriangle запущен");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyTriangleDoesNotExistException.class,()-> triangle.triangleArea(10,15,200));
        logger.info("Тест testCheckingForTriangle завершен");
    }


}


