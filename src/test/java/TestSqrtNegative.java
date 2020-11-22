import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSqrtNegative {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testSqrtNegative() {
        boolean result = Double.isNaN(calculator.sqrt(-4));
        Assert.assertTrue(result, "Не учтена ОДЗ квадратного корня!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
