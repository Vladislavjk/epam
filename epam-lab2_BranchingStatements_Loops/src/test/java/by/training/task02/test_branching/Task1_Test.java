package by.training.task02.test_branching;

import by.training.task02.tasks_branching.Task1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task1_Test {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new int[]{0, 0}, true},
                {new int[]{1, 2}, false},
                {new int[]{3, 2}, false},
                {new int[]{-1, -1}, true},
                {new int[]{1488, 1488}, true},
                {new int[]{-7, 0}, false}
        };
    }

    @Test(description = "Correct tests",
        dataProvider = "allData")
    public void test(int input[], boolean expected) {
        boolean actual = Task1.isEqual(input[0], input[1]);
        assertEquals(actual, expected);
    }
}
