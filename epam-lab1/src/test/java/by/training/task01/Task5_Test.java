package by.training.task01;

import by.training.task01.tasks.Task5;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5_Test {
    @DataProvider(name = "allData")
    public Object[][] createDataToCalcDistance() {
        return new Object[][]{
                {new double[]{0, 0, 0, 0}, 0},
                {new double[]{3.2, 3.2, 3.2, 3.2}, 0},
                {new double[]{-3, -5, -3, -3}, 2},
                {new double[]{2, 3, 3, 5}, Math.sqrt(5)},
                {new double[]{1, -0.125, -6, -0.125}, 7},
                {new double[]{5, 11, 8, 15}, 5}
        };
    }

    @Test(description = "Positive scenary of the distance calculation",
            dataProvider = "allData")
    public void testCalcDistance(double input[], double expected) {
        double actual = Task5.getDistance(input[0], input[1], input[2], input[3]);
        assertEquals(actual, expected);

    }
}
