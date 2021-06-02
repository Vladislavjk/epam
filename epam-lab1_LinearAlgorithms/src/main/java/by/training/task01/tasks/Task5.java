package by.training.task01.tasks;

public final class Task5 {
    /**
     * method finds the distance between 2 points on plane
     * @param x1 - x-axis coordinate of 1 point
     * @param y1 - y-axis coordinate of 1 point
     * @param x2 - x-axis coordinate of 2 point
     * @param y2 - y-axis coordinate of 2 point
     * @return distance between 2 points on plane
     */
    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
