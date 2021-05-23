package by.training.task01.tasks;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class Task3 {
    static final Logger logger = LogManager.getLogger(Task3.class);

    /**
     * a, b, c, d - first, second, third and fourth digits in number respectively
     * method finds (a * c) / (b * d)
     * @param number - four-digit number
     * @return value of (a * c) / (b * d)
     */
    public static double getQuotient(int number) {
        if(number < 1000 && number >= 10000) {
            logger.error("Number is not four-digit");
            throw new IllegalArgumentException("Number is not four-digit");
        }

        int first = number / 1000;
        int second = (number / 100) % 10;
        int third = (number / 10) % 10;
        int fourth = number % 10;

        if(second * fourth == 0) {
            logger.error("Cannot divide by zero");
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        return (first * third) / (double)(second * fourth);
    }
}
