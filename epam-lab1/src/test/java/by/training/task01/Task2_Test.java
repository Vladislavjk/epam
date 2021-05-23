package by.training.task01;

import by.training.task01.tasks.Task2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2_Test {
    @DataProvider(name = "posAndNegDataIntoDegrees")
    public Object[][] createDataToConvertIntoDegrees() {
        return new Object[][]{
                {new double[]{2 * Math.PI}, 360},
                {new double[]{4}, 4 / Math.PI * 180},
                {new double[]{0}, 0},
                {new double[]{-1.5 * Math.PI}, -270},
                {new double[]{-3 * Math.PI}, -540},
                {new double[]{-5}, -5 / Math.PI * 180}
        };
    }

    @Test(description = "Positive conversion result",
            dataProvider = "posAndNegDataIntoDegrees")
    public void testConvertIntoDegrees(double input[], double expected) {
        double actual = Task2.getDegrees(input[0]);
        assertEquals(actual, expected);

    }

    @DataProvider(name = "posAndNegDataIntoMinutes")
    public Object[][] createDataToConvertIntoMinutes() {
        return new Object[][]{
                {new double[]{2 * Math.PI}, 360 * 60},
                {new double[]{4}, 4 / Math.PI * 180 * 60},
                {new double[]{0}, 0},
                {new double[]{-1.5 * Math.PI}, -270 * 60},
                {new double[]{-3 * Math.PI}, -540 * 60},
                {new double[]{-5}, -5 / Math.PI * 180 * 60}
        };
    }

    @Test(description = "Positive conversion result",
            dataProvider = "posAndNegDataIntoMinutes")
    public void testConvertIntoMinutes(double input[], double expected) {
        double actual = Task2.getMinutes(input[0]);
        assertEquals(actual, expected);

    }

    @DataProvider(name = "posAndNegDataIntoSeconds")
    public Object[][] createDataToConvertIntoSeconds() {
        return new Object[][]{
                {new double[]{2 * Math.PI}, 360 * 3600},
                {new double[]{4}, 4 / Math.PI * 180 * 3600},
                {new double[]{0}, 0},
                {new double[]{-1.5 * Math.PI}, -270 * 3600},
                {new double[]{-3 * Math.PI}, -540 * 3600},
                {new double[]{-5}, -5 / Math.PI * 180 * 3600}
        };
    }

    @Test(description = "Positive conversion result",
            dataProvider = "posAndNegDataIntoSeconds")
    public void testConvertIntoSeconds(double input[], double expected) {
        double actual = Task2.getSeconds(input[0]);
        assertEquals(actual, expected);

    }
}
