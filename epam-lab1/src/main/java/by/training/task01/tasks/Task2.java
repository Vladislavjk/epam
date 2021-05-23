package by.training.task01.tasks;

public final class Task2 {
    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in degrees
     */
    public static double getDegrees(double radians) {
        return (radians / Math.PI) * 180;
    }

    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in minutes
     */
    public static double getMinutes(double radians) {
        return getDegrees(radians) * 60;
    }

    /**
     * @param radians - measure of angle in radians
     * @return measure of angle in seconds
     */
    public static double getSeconds(double radians) {
        return getMinutes(radians) * 60;
    }
}
