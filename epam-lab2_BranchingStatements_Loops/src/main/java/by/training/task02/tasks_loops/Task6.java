package by.training.task02.tasks_loops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    static final Logger logger = LogManager.getLogger(Task6.class);

    /**
     * method prints even numbers in [2, 100]
     * @return resulting string
     */
    public static String printEven() {
        int i = 2;
        String res = "";
        while(i <= 100) {
            res += i + " ";
            i += 2;
        }
        System.out.println(res);
        logger.info(res);
        return res;
    }
}
