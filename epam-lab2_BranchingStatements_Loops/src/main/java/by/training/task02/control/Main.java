package by.training.task02.control;

import by.training.task02.tasks_branching.*;
import by.training.task02.tasks_loops.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void showMenu() {
        System.out.println("1 - Равны ли 2 числа a и b");
        System.out.println("2 - Даны три действительных числа. Возвести в квадрат те из них, значения которых неотрицательны, и в четвертую степень — отрицательные.");
        System.out.println("3 - Определить, делителем каких чисел а, b, с является число k.");
        System.out.println("4 - Даны три числа a, b, с. Определить, какое из них равно d. Если ни одно не равно d, то найти max(d — a, d — b, d — c).");
        System.out.println("5 - Вычислить значение функции f(x)");
        System.out.println("6 - Вывод всех четных чисел in [2, 100]");
        System.out.println("7 - Произведение первых 10 членов последовательности an = 6 + an-1, a1 = 1");
        System.out.println("8 - Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен заданному е.");
        System.out.println("9 - Калькулятор с операциями +-*/ для 2 операндов");
        System.out.println("10 - Два двузначных числа, записанных одно за другим , образуют четырёхзначное число, которое делится на их произведение. Найти эти числа.");
        System.out.println("11 - Выйти из программы");
    }


    public static void main(String[] args) {
        boolean isRunning = true;
        showMenu();
        Scanner sc = new Scanner(System.in);
        while(isRunning) {
            String next = sc.nextLine();
            switch (next) {
                case "1" : {
                    System.out.println("Введите 2 числа a и b");
                    logger.info("Введите 2 числа a и b");
                    int a = Integer.parseInt(sc.nextLine());
                    int b = Integer.parseInt(sc.nextLine());
                    if(Task1.isEqual(a, b)) {
                        System.out.println("a == b");
                        logger.info("a == b");
                    }
                    else {
                        System.out.println("a != b");
                        logger.info("a != b");
                    }
                    break;
                }
                case "2" : {
                    System.out.println("Введите 3 числа");
                    logger.info("Введите 3 числа");
                    int a = Integer.parseInt(sc.nextLine());
                    int b = Integer.parseInt(sc.nextLine());
                    int c = Integer.parseInt(sc.nextLine());
                    System.out.println(Task2.transformNumber(a));
                    logger.info(Task2.transformNumber(a));
                    System.out.println(Task2.transformNumber(b));
                    logger.info(Task2.transformNumber(b));
                    System.out.println(Task2.transformNumber(c));
                    logger.info(Task2.transformNumber(c));
                    break;
                }
                case "3" : {
                    System.out.println("Введите 4 числа");
                    logger.info("Введите 4 числа");
                    int a = Integer.parseInt(sc.nextLine());
                    int b = Integer.parseInt(sc.nextLine());
                    int c = Integer.parseInt(sc.nextLine());
                    int k = Integer.parseInt(sc.nextLine());
                    System.out.println(Task3.isFactor(a, k));
                    logger.info(Task3.isFactor(a, k));
                    System.out.println(Task3.isFactor(b, k));
                    logger.info(Task3.isFactor(b, k));
                    System.out.println(Task3.isFactor(c, k));
                    logger.info(Task3.isFactor(c, k));
                    break;
                }
                case "4" : {
                    System.out.println("Введите 4 числа");
                    logger.info("Введите 4 числа");
                    int a = Integer.parseInt(sc.nextLine());
                    int b = Integer.parseInt(sc.nextLine());
                    int c = Integer.parseInt(sc.nextLine());
                    int d = Integer.parseInt(sc.nextLine());
                    System.out.println(Task1.isEqual(a, d));
                    logger.info(Task1.isEqual(a, d));
                    System.out.println(Task1.isEqual(b, d));
                    logger.info(Task1.isEqual(b, d));
                    System.out.println(Task1.isEqual(b, d));
                    logger.info(Task1.isEqual(b, d));

                    if(Task1.isEqual(a, d) == false && Task1.isEqual(b, d) == false && Task1.isEqual(c, d) == false) {
                        System.out.println(Task4.calculateMax(a, b, c, d));
                        logger.info(Task4.calculateMax(a, b, c, d));
                    }

                    break;
                }
                case "5" : {
                    System.out.println("Введите x");
                    double x = Double.parseDouble(sc.nextLine());
                    System.out.println("Function value = " + Task5.calculateValue(x));
                    logger.info("Function value = " + Task5.calculateValue(x));
                    break;
                }
                case "6" : {
                    System.out.println("Все четные числа от 2 до 100 : ");
                    Task6.printEven();
                    break;
                }
                case "7" : {
                    System.out.println(Task7.calculateProduct());
                    logger.info(Task7.calculateProduct());
                    break;
                }
                case "8" : {
                    System.out.println("Введите e");
                    double e = Double.parseDouble(sc.nextLine());
                    System.out.println(Task8.calculateSum(e));
                    logger.info(Task8.calculateSum(e));
                    break;
                }
                case "9" : {
                    try {
                        Task9.calculateValue();
                    }
                    catch (IllegalArgumentException exception) {
                        logger.error("Cannot divide by zero");
                    }
                    break;
                }
                case "10" : {
                    Task10.printNumbers();
                    break;
                }
                case "11" : {
                    isRunning = false;
                    logger.info("Exit the program");
                    break;
                }
                default : {
                    System.out.println("Неправильный ввод. Повторите заново.");
                    logger.info("Неправильный ввод. Повторите заново.");
                    break;
                }
            }
        }
    }
}
