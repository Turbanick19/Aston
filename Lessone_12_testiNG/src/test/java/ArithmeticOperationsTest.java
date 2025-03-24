import org.Lessone_12_testiNG.ArithmeticOperations;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(3, 4), 7, "Сумма неверная");
    }

    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(5, 4), 1, "Разность неверная");
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(4, 5), 20, "Произведение неверное");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZeroThrowsException() {
        ArithmeticOperations.divide(10, 0); // Деление на ноль должно вызывать исключение
    }
}

