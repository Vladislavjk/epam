package by.training.task01;

import by.training.task01.tasks.Task4;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task4_Test {
    @DataProvider(name = "posAndNegData")
    public Object[][] createDataToCalcFunctionValue() {
        return new Object[][]{
                {new double[]{0, 0, 0}, 0},
                {new double[]{3, 10, 2}, 2},
                {new double[]{-3, -5, -2}, 13},
                {new double[]{4, 3, 1}, 2.5},
                {new double[]{5.5, 4.5, 2.1}, 7.725},
                {new double[]{-2, 0, -1.5}, -1.5}
        };
    }

    @Test(description = "Correct function value calculation",
            dataProvider = "posAndNegData")
    public void testCalcFunctionValue(double input[], double expected) {
        double actual = Task4.getFunctionValue(input[0], input[1], input[2]);
        assertEquals(actual, expected);

    }
}
