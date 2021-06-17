package by.training.task03.service;

import by.training.task03.validator.Validator;
import by.training.task03.exception.CustomArrayException;
import by.training.task03.entity.CustomArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomArraySortService {

    private static final Validator validator = new Validator();
    private static final Logger logger = LogManager.getLogger(CustomArraySortService.class);

    public void bubbleSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using bubble sort) array.");
        validator.validateArray(array);

        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.atIndex(j) > array.atIndex(j + 1)) {
                    //swap a[j], a[j + 1]
                    int prev = array.atIndex(j);
                    int next = array.atIndex(j + 1);

                    array.setAtIndex(j, next);
                    array.setAtIndex(j + 1, prev);
                }
            }
        }

        logger.info("Bubble sort method finished.");
    }

    public void insertionSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using insertion sort) array.");
        validator.validateArray(array);

        for (int i = 1; i < array.size(); i++) {
            int j = i;
            while (j > 0 && array.atIndex(j) < array.atIndex(j - 1)) {
                //swap a[j - 1], a[j]
                int prev = array.atIndex(j - 1);
                int next = array.atIndex(j);

                array.setAtIndex(j, prev);
                array.setAtIndex(j - 1, next);

                j--;
            }
        }

        logger.info("Insertion sort method finished.");
    }

    public void selectionSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using selection sort) array.");
        validator.validateArray(array);

        for (int i = 0; i < array.size(); i++) {
            int mininalElementIndex = i;

            for (int j = i; j < array.size(); j++) {
                if (array.atIndex(j) < array.atIndex(mininalElementIndex)) {
                    mininalElementIndex = j;
                }
            }

            //swap a[i], a[minimalElementIndex]
            int prev = array.atIndex(i);
            int next = array.atIndex(mininalElementIndex);

            array.setAtIndex(i, next);
            array.setAtIndex(mininalElementIndex, prev);
        }

        logger.info("Selection sort method finished.");
    }
}

