
import org.Lessone_12_testiNG.TriangleArea;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleAreaTest {
    private TriangleArea TriangleAreaCalculator;

    @Test
    public void testValidArea() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testZeroBase() {
        TriangleArea.calculateArea(0, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeHeight() {
        TriangleArea.calculateArea(5, -4);
    }
}

