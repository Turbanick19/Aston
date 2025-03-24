import org.Lessone_12_testiNG.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculateFactorial(0), 1L);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.calculateFactorial(1), 1L);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(Factorial.calculateFactorial(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegative() {
        Factorial.calculateFactorial(-1);
    }
}



