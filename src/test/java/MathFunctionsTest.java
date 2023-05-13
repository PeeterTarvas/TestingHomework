import org.example.MathFunctions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MathFunctionsTest {
    @Test
    public void testFactorialBasic() {
        assertEquals(1, MathFunctions.factorial(0, 1000000));
        assertEquals(1, MathFunctions.factorial(1, 1000000));
        assertEquals(2, MathFunctions.factorial(2, 1000000));
        assertEquals(6, MathFunctions.factorial(3, 1000000));
        assertEquals(24, MathFunctions.factorial(4, 1000000));
        assertEquals(120, MathFunctions.factorial(5, 1000000));
        assertEquals(362880, MathFunctions.factorial(10, 1000000));
    }

    @Test
    public void testFactorialNegative() {
        try {
            MathFunctions.factorial(-1, 1000000);
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers are not allowed.", e.getMessage());
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative2() {
        MathFunctions.factorial(-1, 1000000);
    }

    @Test
    public void testFactorialMod() {
        assertEquals(120, MathFunctions.factorial(5, 1000));
        assertEquals(240, MathFunctions.factorial(6, 1000));
        assertEquals(720, MathFunctions.factorial(6, 10000));
        assertEquals(776320, MathFunctions.factorial(10, 1000000));
    }

    // Optional parametrized test
    @Test
    public void testFactorialParametrized() {
        int[][] testCases = {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {10, 3628800}
        };
        for (int[] testCase : testCases) {
            int input = testCase[0];
            int expectedOutput = testCase[1];
            assertEquals(expectedOutput, MathFunctions.factorial(input,100));
        }
    }
}