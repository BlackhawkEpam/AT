package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDivLong {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testDivLong() {
        long result = calculator.div(10,5);
        Assert.assertEquals(result, 2, "Частное не совпадает!");
    }

    @Test(expectedExceptions = { NumberFormatException.class })
    public void testDivNull() {
        calculator.div(6,0);
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
