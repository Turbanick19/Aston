import org.Lessone_12_testiNG.CompareNumbers;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class CompareNumbersTest{

    @Test
    public void testIsEqualTrue() {
        assertTrue(CompareNumbers.areEqual(5, 5), "Сравнение неверное");
    }

    @Test
    public void testIsEqualFalse() {
        assertFalse(CompareNumbers.areEqual(3,5), "Сравнение неверное");
    }

    @Test
    public void testIsGreaterThanTrue() {
        assertTrue(CompareNumbers.isGreaterThan(8, 5), "Сравнение неверное");
    }

    @Test
    public void testIsGreaterThanFalse() {
        assertFalse(CompareNumbers.isGreaterThan(3, 5), "Сравнение неверное");
    }

    @Test
    public void testIsLessThanTrue() {
        assertTrue(CompareNumbers.isLessThan(3, 5), "Сравнение неверное");
    }

    @Test
    public void testIsLessThanFalse() {
        assertFalse(CompareNumbers.isLessThan(8, 5), "Сравнение неверное");
    }
}
