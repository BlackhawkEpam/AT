package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSignCheckPlus {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testignCheckPlus() {
        boolean result = calculator.isPositive(8);
        Assert.assertTrue(result, "Проверка знака дала некорректный результат!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
