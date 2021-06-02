package by.training.task02.tasks_loops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task10 {
    static final Logger logger = LogManager.getLogger(Task10.class);

    /**
     * method prints 4-digit numbers such that number % ((number % 100) * (number / 100)) == 0
     */
    public static String printNumbers() {
        String res = "";

        for(int i = 1000; i < 10000; i++) {
            int first = i / 100;
            int second = i % 100;

            if(first * second == 0) {
                continue;
            }

            if(i % (first * second) == 0) {
                res += i + " ";
            }
        }

        System.out.println("Suitable numbers : " + res);
        logger.info("Suitable numbers : " + res);
        return res;
    }
}
