package by.training.task02.test_loops;

import by.training.task02.tasks_loops.Task6;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task6_Test {
    @Test(description = "Correct tests")
    public void test() {
        final String expected = "2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62" +
                " 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 100 ";
        String actual = Task6.printEven();
        assertEquals(actual, expected);

    }
}
