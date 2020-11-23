package HW3;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"BasicOperations"})
public class TestSubLong {
    @BeforeClass
    public void SetUp() {
        calculator = new Calculator();
    }

    private Calculator calculator;

    @Test(dataProvider = "dataProviderForSub")
    public void testSubLong(long a, long b, long l1) {
        long result = calculator.sub(a,b);
        Assert.assertEquals(result, l1, "Разность не совпадает!");
    }

    @DataProvider(name="dataProviderForSub")
    public Object[][] subValues() {
        return new Object[][] {
                {3,5,-2},
                {5,5,0},
                {11,7,4}
        };
    }

    @AfterClass
    public void TearDown() {
        calculator = null;
    }
}
