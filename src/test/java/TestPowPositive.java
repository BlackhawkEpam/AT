import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPowPositive {
    private static Calculator calculator;

    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    @Test
    public void testPowPositive() {
        double result = calculator.pow(3,4);
        Assert.assertEquals(81, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
