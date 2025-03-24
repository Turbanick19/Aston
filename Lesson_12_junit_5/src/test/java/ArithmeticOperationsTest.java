import Lesson_12_junit_5.ArithmeticOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void testAddition() {
        assertEquals(7, ArithmeticOperations.add(4, 4), "Сумма неверная");
    }

    @Test
    void testSubtraction() {
        assertEquals(1, ArithmeticOperations.subtract(5, 4), "Разность неверная");
    }

    @Test
    void testMultiplication() {
        assertEquals(20, ArithmeticOperations.multiply(4, 5), "Произведение неверное");
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0),
                "Деление на ноль должно вызывать исключение");
    }
}
