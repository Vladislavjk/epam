package by.training.task02.test_branching;

import by.training.task02.tasks_branching.Task3;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task3_Test {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new int[]{15, -5, 0, 5}, new boolean[]{true, true, true}},
                {new int[]{0, 1, -1, 13}, new boolean[]{true, false, false}},
                {new int[]{2, 3, 5, 1}, new boolean[]{true, true, true}},
                {new int[]{13, 17, 19, 3}, new boolean[]{false, false, false}},
                {new int[]{5, 11, 20, 4}, new boolean[]{false, false, true}},
                {new int[]{2, 12, 42, 6}, new boolean[]{false, true, true}}
        };
    }

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void test(int input[], boolean[] expected) {
        boolean[] actual = new boolean[3];
        for(int i = 0; i < 3; i++) {
            actual[i] = Task3.isFactor(input[i], input[3]);
        }
        assertEquals(actual, expected);
    }
}
