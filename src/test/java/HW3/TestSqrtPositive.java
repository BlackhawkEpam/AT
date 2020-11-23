package HW3;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSqrtPositive {
    private static Calculator calculator;

    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSqrtPositive() {
        double result = calculator.sqrt(100);
        Assert.assertEquals(10, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
