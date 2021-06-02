package by.training.task02.test_branching;

import by.training.task02.tasks_branching.Task2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2_Test {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new double[]{1, 0, -1}, new double[]{1, 0, 1}},
                {new double[]{1, 2, 3}, new double[]{1, 4, 9}},
                {new double[]{2, -2, -3}, new double[]{4, 16, 81}},
                {new double[]{0.5, -0.5, 1.5}, new double[]{0.25, 0.0625, 2.25}},
                {new double[]{0, 0, 0}, new double[]{0, 0, 0}},
                {new double[]{-2, -2, -2}, new double[]{16, 16, 16}}
        };
    }

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void test(double input[], double[] expected) {
        double[] actual = new double[3];
        for(int i = 0; i < 3; i++) {
            actual[i] = Task2.transformNumber(input[i]);
        }
        assertEquals(actual, expected);
    }
}
