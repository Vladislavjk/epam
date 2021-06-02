package by.training.task02.tasks_loops;

public class Task8 {
    /**
     * @param e - accuracy
     * @return series sum an = 1 / ((3 * n - 2) * (3 * n + 1)) with accuracy e
     */
    public static double calculateSum(double e) {
        double sum = 0;
        double curr = 0.25;
        int i = 2;

        while(curr >= e) {
            sum += curr;
            curr = 1 / (double)((3 * i - 2) * (3 * i + 1));
            i++;
        }

        return sum;
    }
}
