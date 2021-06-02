package by.training.task02.test_loops;

import by.training.task02.tasks_loops.Task7;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task7_Test {
    @Test(description = "Correct tests")
    public void test() {
        final long expected = 5745471106375l;
        long actual = Task7.calculateProduct();
        assertEquals(actual, expected);
    }
}
