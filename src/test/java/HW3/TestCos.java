package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups = {"BasicFunction"})
public class TestCos {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    @Parameters("ExpectedResult")
    public void testCos(double ExpectedResult) {
        double result = calculator.cos(Math.toRadians(180));
        Assert.assertEquals(result, ExpectedResult, "Возвращено некорректное значение косинуса!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
