package HW3;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSignCheckMinus {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testSignCheckMinus() {
        boolean result = calculator.isNegative(-5);
        Assert.assertTrue(result);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
