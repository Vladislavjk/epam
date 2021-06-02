package by.training.task02.tasks_loops;

public class Task7 {
    /**
     * given a sequence an = 6 + an-1, a1 = 1
     * @return product of first 10 terms
     */
    public static long calculateProduct() {
        long a = 1;
        long product = 1;
        for(int i = 2; i <= 10; i++) {
            a += 6;
            product *= a;
        }
        return product;
    }
}
