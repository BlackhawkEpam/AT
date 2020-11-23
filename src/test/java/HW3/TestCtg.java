package HW3;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtg {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testCtg() {
        double result = calculator.ctg(Math.toRadians(45));
        Assert.assertEquals(1, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
