import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDivDouble {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testDivDouble() {
        double result = calculator.div(80, 10);
        Assert.assertEquals(8, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
