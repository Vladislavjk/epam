package by.training.task01;

import by.training.task01.tasks.Task1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class Task1_Test {
    @DataProvider(name = "positiveLengthToCalcArea")
    public Object[][] createDataToCalcArea() {
        return new Object[][]{
                {new double[]{2 * Math.PI}, Math.PI},
                {new double[]{4 * Math.PI}, 4 * Math.PI},
                {new double[]{0}, 0},
                {new double[]{1.5}, 9 / (16 * Math.PI)},
                {new double[]{2}, 1 / Math.PI},
                {new double[]{6}, 9 / Math.PI}
        };
    }

    @DataProvider(name = "negativeLengthToCalcArea")
    public Object[] createNegativeDataToCalcArea() {
        return new Object[]{-4.0, -100.0, -0.36};
    }

    @Test(description = "Positive scenary of the area calculation",
            dataProvider = "positiveLengthToCalcArea")
    public void testCalcArea(double input[], double expected) {
        double actual = Task1.getArea(input[0]);
        assertEquals(actual, expected);

    }

    @Test(description = "Negative scenary of the area calculation",
            dataProvider = "negativeLengthToCalcArea")
    public void testCalcArea(double input[]) {
        assertThrows(Exception.class, () -> Task1.getArea(input[0]));
    }
}
