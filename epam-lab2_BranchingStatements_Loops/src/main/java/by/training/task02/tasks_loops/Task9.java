package by.training.task02.tasks_loops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Task9 {
    static final Logger logger = LogManager.getLogger(Task9.class);

    /**
     * you enter x, y and operation
     * method calculates the result, stops when you enter "0"
     * @throws IllegalArgumentException when y == 0 and operation = "/"
     */
    public static void calculateValue() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while(isRunning) {
            System.out.println("Введите x, y и операцию");
            int x = Integer.parseInt(scanner.nextLine());
            int y = Integer.parseInt(scanner.nextLine());
            String operation = scanner.nextLine();
            switch (operation) {
                case "+" : {
                    System.out.println("x + y == " + (x + y));
                    logger.info("x + y == " + (x + y));
                    break;
                }

                case "-" : {
                    System.out.println("x - y == " + (x - y));
                    logger.info("x - y == " + (x - y));
                    break;
                }

                case "*" : {
                    System.out.println("x * y == " + (x * y));
                    logger.info("x * y == " + (x * y));
                    break;
                }

                case "/" : {
                    if(y == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero");
                    }
                    System.out.println("x / y == " + (x / (double)y));
                    logger.info("x / y == " + (x / (double)y));
                    break;
                }

                case "0" : {
                    isRunning = false;
                    System.out.println("Калькулятор прекратил работу");
                    logger.info("Калькулятор прекратил работу");
                    break;
                }

                default: {
                    System.out.println("Wrong input, Re-enter the operation");
                    logger.info("Wrong input, Re-enter the operation");
                    break;
                }
            }
        }
    }
}
