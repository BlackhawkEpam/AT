package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPowNegative {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testPowNegative() {
        double result = calculator.pow(5, -2);
        Assert.assertEquals(result, 0.04, "Операция возведения в степень возвращает некорректный результат!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
