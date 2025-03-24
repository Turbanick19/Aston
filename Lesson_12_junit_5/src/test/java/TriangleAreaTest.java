import Lesson_12_junit_5.TriangleArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    void testValidSides() {
        double area = TriangleArea.triangleArea(3, 4, 5);
        assertEquals(6.0, area, 0.00001, "Площадь треугольника неверная");
    }

    @Test
    void testInvalidSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.triangleArea(1, 2, -3),
                "Отрицательная сторона должна вызывать исключение");
    }
}
