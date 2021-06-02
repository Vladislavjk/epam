package by.training.task02.tasks_branching;

public class Task2 {
    /**
     * @param a - real number
     * @return a^4 if a < 0 else a^2
     */
    public static double transformNumber(double a) {
        if(a < 0) {
            return Math.pow(a, 4);
        }
        else {
            return Math.pow(a, 2);
        }
    }
}
