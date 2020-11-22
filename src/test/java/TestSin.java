import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSin {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testSin90() {
        double result = calculator.sin(Math.toRadians(90));
        Assert.assertEquals(1, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
