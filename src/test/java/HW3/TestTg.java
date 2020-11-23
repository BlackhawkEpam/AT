package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTg {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testTg() {
        double result = calculator.tg(Math.toRadians(0));
        Assert.assertEquals(result, 0.0, "Возвращено некорректное значение тангенса!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
