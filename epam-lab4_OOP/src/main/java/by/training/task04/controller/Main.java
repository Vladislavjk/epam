package by.training.task04.controller;

import by.training.task04.bean.Country;
import by.training.task04.view.MessageManager;
import by.training.task04.service.creator.CountryCreator;
import by.training.task04.service.exception.ServiceException;
import by.training.task04.view.ViewImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {  // TODO COMMAND
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ViewImpl viewImpl = new ViewImpl();
        CountryCreator countryCreator = new CountryCreator();
        Scanner sc = new Scanner(System.in);

        System.out.println("1 -> ru\n2 -> by\nAny -> default(eng)");
        String choice = sc.nextLine();
        MessageManager messageManager;
        switch (choice) { // TODO String.valueOf to enum
            case "1" -> {
                messageManager = MessageManager.RU;
                break;
            }
            case "2" -> {
                messageManager = MessageManager.BY;
                break;
            }
            default -> {
                messageManager = MessageManager.DEFAULT;
                break;
            }
        }


        try {
            Country country = countryCreator.createCountry("input_files/cities.txt"); // TODO ask user
            viewImpl.showMenu(messageManager);
            Boolean isRunning = true;

            while (isRunning) {
                String next = sc.nextLine();

                switch (next) {
                    case "1" : {
                        System.out.println(country.getRegions());
                        break;
                    }
                    case "2" : {
                        System.out.println(country.amountOfRegions());
                        break;
                    }
                    case "3" : {
                        System.out.println(country.getArea());
                        break;
                    }
                    case "4" : {
                        isRunning = false;
                        logger.info("Exit the program");
                        break;
                    }
                    default : {
                        viewImpl.incorrectInput(messageManager);
                        break;
                    }
                }
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
    }
}
