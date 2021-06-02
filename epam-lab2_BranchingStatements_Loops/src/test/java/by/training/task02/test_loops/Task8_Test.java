package by.training.task02.test_loops;

import by.training.task02.tasks_loops.Task8;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task8_Test {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new double[]{0.25}, 0.25},
                {new double[]{0.155}, 0.25},
                {new double[]{1e-3}, 0.32258064516129037},
                {new double[]{1e-6}, 0.3329999999999997},
                {new double[]{1e-10}, 0.33332614043416225},
                {new double[]{1}, 0}
        };
    }

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void test(double input[], double expected) {
        double actual = Task8.calculateSum(input[0]);
        assertEquals(actual, expected);
    }
}
