package by.training.task02.test_branching;

import by.training.task02.tasks_branching.Task1;
import by.training.task02.tasks_branching.Task4;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task4_Test {
    @DataProvider(name = "existEqual")
    public Object[][] existEqual() {
        return new Object[][]{
                {new int[]{15, -5, 0, -5}, new boolean[]{false, true, false}},
                {new int[]{0, 0, 0, 0}, new boolean[]{true, true, true}},
                {new int[]{2, 1, 1, 1}, new boolean[]{false, true, true}},
                {new int[]{3, 17, 19, 3}, new boolean[]{true, false, false}},
                {new int[]{-4, 11, -4, -4}, new boolean[]{true, false, true}},
                {new int[]{2, 6, 42, 6}, new boolean[]{false, true, false}}
        };
    }

    @DataProvider(name = "notExistEqual")
    public Object[][] notExistEqual() {
        return new Object[][]{
                {new int[]{15, -5, 0, 5}, 10},
                {new int[]{0, 1, -1, 13}, 14},
                {new int[]{2, 3, 5, 1}, -1},
                {new int[]{13, 17, 19, 3}, -10},
                {new int[]{5, 11, 20, 4}, -1},
                {new int[]{2, 12, 42, 6}, 4}
        };
    }

    @Test(description = "Exist equal",
            dataProvider = "existEqual")
    public void testExistEqual(int input[], boolean[] expected) {
        boolean[] actual = new boolean[3];
        for(int i = 0; i < 3; i++) {
            actual[i] = Task1.isEqual(input[i], input[3]);
        }
            assertEquals(actual, expected);
    }

    @Test(description = "Doesn't exist equal",
            dataProvider = "notExistEqual")
    public void testNotExistEqual(int input[], int expected) {
        int actual = Task4.calculateMax(input[0], input[1], input[2], input[3]);
        assertEquals(actual, expected);
    }
}
