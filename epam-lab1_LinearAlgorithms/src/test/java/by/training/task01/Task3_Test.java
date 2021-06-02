package by.training.task01;

import by.training.task01.tasks.Task3;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class Task3_Test {
    @DataProvider(name = "expectedValidData")
    public Object[][] createDataToCalcValue() {
        return new Object[][]{
                {new int[]{1562}, 0.6},
                {new int[]{4444}, 1},
                {new int[]{1555}, 0.2},
                {new int[]{9191}, 81},
                {new int[]{1102}, 0},
                {new int[]{1717}, 1 / 49.}
        };
    }

    @DataProvider(name = "non-four-digitNumbers")
    public Object[] createNegativeDataToCalcValue1() {
        return new Object[]{1100010, 12212919, 23, 1, 172};
    }

    @DataProvider(name = "b * d == 0")
    public Object[] createNegativeDataToCalcValue2() {
        return new Object[]{1010, 2025, 9990, 1110, 1022};
    }

    @Test(description = "Positive scenary of (a * c) / (b * d) calculation",
            dataProvider = "expectedValidData")
    public void testCalc(int input[], double expected) {
        double actual = Task3.getQuotient(input[0]);
        assertEquals(actual, expected);

    }

    @Test(description = "Negative scenary of (a * c) / (b * d) calculation",
            dataProvider = "non-four-digitNumbers")
    public void testCalc1(int input[]) {
        assertThrows(Exception.class, () -> Task3.getQuotient(input[0]));
    }

    @Test(description = "Negative scenary of (a * c) / (b * d) calculation",
            dataProvider = "b * d == 0")
    public void testCalc2(int input[]) {
        assertThrows(Exception.class, () -> Task3.getQuotient(input[0]));
    }
}
