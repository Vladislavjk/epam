package by.training.task02.tasks_branching;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    static final Logger logger = LogManager.getLogger(Task4.class);

    /**
     * @param a - integer number
     * @param b - integer number
     * @param c - integer number
     * @param d - integer number
     * @return max(d - a, d - b, d - c)
     */
    public static int calculateMax(int a, int b, int c, int d) {
        return Math.max(Math.max(d - a, d - b), d - c);
    }
}
