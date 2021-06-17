package by.training.task03.control;

import by.training.task03.creator.CustomArrayCreator;
import by.training.task03.entity.CustomArray;
import by.training.task03.exception.CustomArrayException;

public class Main {
    public static void main(String[] args) throws CustomArrayException {
        CustomArrayCreator cac = new CustomArrayCreator();
        CustomArray array = cac.createCustomArray("input.txt");
    }
}
