package HW3;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSubDouble {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testSubDouble() {
        double result = calculator.sub(7, 7);
        Assert.assertEquals(0, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
