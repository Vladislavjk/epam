package by.training.task01.control;

import by.training.task01.tasks.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void showMenu() {
        System.out.println("1 - Известна длина окружности. Найти площадь круга, ограниченного этой окружностью");
        System.out.println("2 - Составить программу перевода радианной меры угла в градусы, минуты и секунды");
        System.out.println("3 - Найти частное произведений четных и нечетных цифр четырехзначного числа");
        System.out.println("4 - Найдите значение функции: z = ( (a – 3 ) * b / 2) + c");
        System.out.println("5 - Вычислить расстояние между двумя точками с данными координатами (х1, у1)и (x2, у2)");
        System.out.println("6 - Выйти из программы");
    }

    public static void main(String[] args) {
        Boolean isRunning = true;
        showMenu();
        Scanner sc = new Scanner(System.in);
        while(isRunning) {
            String next = sc.nextLine();
            switch (next) {
                case "1" : {
                    System.out.println("Введите длину окружности");
                    logger.info("Введите длину окружности");
                    double length = Double.parseDouble(sc.nextLine());
                    System.out.println("Площадь круга = " + Task1.getArea(length));
                    logger.info("Площадь круга = " + Task1.getArea(length));
                    break;
                }
                case "2" : {
                    System.out.println("Введите радианную меру");
                    logger.info("Введите радианную меру");
                    double radians = Double.parseDouble(sc.nextLine());
                    System.out.println("Мера угла в градусах = " + Task2.calculateDegrees(radians));
                    logger.info("Мера угла в градусах = " + Task2.calculateDegrees(radians));
                    System.out.println("Мера угла в минутах = " + Task2.calculateMinutes(radians));
                    logger.info("Мера угла в минутах = " + Task2.calculateMinutes(radians));
                    System.out.println("Мера угла в секундах = " + Task2.calculateSeconds(radians));
                    logger.info("Мера угла в секундах = " + Task2.calculateSeconds(radians));
                    break;
                }
                case "3" : {
                    System.out.println("Введите четырехзначное число(abcd)");
                    logger.info("Введите четырехзначное число(abcd)");
                    int number = Integer.parseInt(sc.nextLine());
                    System.out.println("(a * c) / (b * d) = " + Task3.getQuotient(number));
                    logger.info("(a * c) / (b * d) = " + Task3.getQuotient(number));
                    break;
                }
                case "4" : {
                    System.out.println("Введите a, b, c");
                    logger.info("Введите a, b, c");
                    double a = Double.parseDouble(sc.nextLine());
                    double b = Double.parseDouble(sc.nextLine());
                    double c = Double.parseDouble(sc.nextLine());
                    System.out.println("Значение функции z = (a - 3) * b / 2 + c = " + Task4.getFunctionValue(a, b, c));
                    logger.info("Значение функции z = (a - 3) * b / 2 + c = " + Task4.getFunctionValue(a, b, c));
                    break;
                }
                case "5" : {
                    System.out.println("Введите x1, y1, x2, y2");
                    logger.info("Введите x1, y1, x2, y2");
                    double x1 = Double.parseDouble(sc.nextLine());
                    double y1 = Double.parseDouble(sc.nextLine());
                    double x2 = Double.parseDouble(sc.nextLine());
                    double y2 = Double.parseDouble(sc.nextLine());
                    System.out.println("Расстояние между точками (x1, y1) и (x2, y2) = " + Task5.getDistance(x1, y1, x2, y2));
                    logger.info("Расстояние между точками (x1, y1) и (x2, y2) = " + Task5.getDistance(x1, y1, x2, y2));
                    break;
                }
                case "6" : {
                    isRunning = false;
                    break;
                }
                default: {
                    System.out.println("Неправильный ввод. Повторите заново.");
                    logger.info("Неправильный ввод. Повторите заново.");
                    break;
                }
            }
        }
    }
}
