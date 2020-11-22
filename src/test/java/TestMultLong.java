import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMultLong {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test
    public void testMultLong() {
        long result = calculator.mult(3,4);
        Assert.assertEquals(result, 12, "Произведение не совпадает!");
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
