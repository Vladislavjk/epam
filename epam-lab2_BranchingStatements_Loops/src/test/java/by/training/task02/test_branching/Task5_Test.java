package by.training.task02.test_branching;

import by.training.task02.tasks_branching.Task5;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5_Test {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new double[]{5}, 1 / 131.},
                {new double[]{3}, 9},
                {new double[]{0}, 9},
                {new double[]{1.5}, 6.75},
                {new double[]{-2.5}, 22.75},
                {new double[]{10}, 1 / 1006.}
        };
    }

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void test(double input[], double expected) {
        double actual = Task5.calculateValue(input[0]);
        assertEquals(actual, expected);
    }
}
