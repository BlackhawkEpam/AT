import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMultDouble {
    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    private static Calculator calculator;

    @Test
    public void testMultDouble() {
        double result = calculator.mult(-9, 4);
        Assert.assertEquals(-36, result, 0);
    }

    @AfterClass
    public static void TearDown() {
        calculator = null;
    }
}
