package HW3;

import com.epam.tat.module4.Calculator;
import org.junit.*;


public class TestSumDouble {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testSumDouble() {
        double result = calculator.sum(4, 9);
        Assert.assertEquals(13, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
