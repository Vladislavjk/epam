package by.training.task02.tasks_branching;

public class Task5 {
    /**
     * @param x - real number
     * @return 1 / (x^3 + 6) if x > 3 else x^2 - 3x + 9
     */
    public static double calculateValue(double x) {
        if(x > 3) {
            return 1 / (Math.pow(x, 3) + 6);
        }
        else {
            return Math.pow(x, 2) - 3 * x + 9;
        }
    }
}
