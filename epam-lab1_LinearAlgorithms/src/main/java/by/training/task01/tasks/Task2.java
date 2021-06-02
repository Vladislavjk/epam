package by.training.task01.tasks;

public final class Task2 {
    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in degrees
     */
    public static double calculateDegrees(double radians) {
        return (radians / Math.PI) * 180;
    }

    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in minutes
     */
    public static double calculateMinutes(double radians) {
        return calculateDegrees(radians) * 60;
    }

    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in seconds
     */
    public static double calculateSeconds(double radians) {
        return calculateMinutes(radians) * 60;
    }
}
