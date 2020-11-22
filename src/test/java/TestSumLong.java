import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"BasicOperations"})
public class TestSumLong {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test(dataProvider = "dataProviderForSum")
    public void testSumLong(long a, long b, long l1) {
        long result = calculator.sum(a,b);
        Assert.assertEquals(result, l1, "Сумма не совпадает!");
    }

    @DataProvider(name="dataProviderForSum")
    public Object[][] sumValues() {
        return new Object[][] {
                {3,5,8},
                {0,0,0}
        };
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
