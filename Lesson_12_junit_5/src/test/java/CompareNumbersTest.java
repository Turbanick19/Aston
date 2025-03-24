import Lesson_12_junit_5.CompareNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareNumbersTest {
    @Test
    void testIsEqualTrue() {
        assertTrue(CompareNumbers.areEqual(5, 5), "Сравнение неверное");
    }

    @Test
    void testIsEqualFalse() {
        assertFalse(CompareNumbers.areEqual(3, 5), "Сравнение неверное");
    }

    @Test
    void testIsGreaterThanTrue() {
        assertTrue(CompareNumbers.isGreaterThan(8, 5), "Сравнение неверное");
    }

    @Test
    void testIsGreaterThanFalse() {
        assertFalse(CompareNumbers.isGreaterThan(3, 5), "Сравнение неверное");
    }

    @Test
    void testIsLessThanTrue() {
        assertTrue(CompareNumbers.isLessThan(3, 5), "Сравнение неверное");
    }

    @Test
    void testIsLessThanFalse() {
        assertFalse(CompareNumbers.isLessThan(8, 5), "Сравнение неверное");
    }
}

