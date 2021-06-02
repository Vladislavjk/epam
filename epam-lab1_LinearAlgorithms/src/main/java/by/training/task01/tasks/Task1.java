package by.training.task01.tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.Math;

public final class Task1 {
    static final Logger logger = LogManager.getLogger(Task1.class);
    /**
     * method finds the area of a circle
     * @param length of a circle
     * @return area of a circle
     * @throws IllegalArgumentException if length < 0
     */
    public static double getArea(double length) { // TODO circle
        if(length < 0) {
            logger.error("Length is not positive");
            throw new IllegalArgumentException("Length is not positive");
        }
        double radius = length / (2 * Math.PI);
        return length * radius / 2;
    }
}
