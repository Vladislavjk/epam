package by.training.task02.test_loops;

import by.training.task02.tasks_loops.Task10;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task10_Test {
    @Test(description = "Correct tests")
    public void test() {
        final String expected = "1352 1734 ";
        String actual = Task10.printNumbers();
        assertEquals(actual, expected);
    }
}
