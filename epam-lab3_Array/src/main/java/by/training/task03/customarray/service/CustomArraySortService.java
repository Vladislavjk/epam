package by.training.task03.customarray.service;

import by.training.task03.customarray.validator.ArrayValidator;
import by.training.task03.customarray.exception.CustomArrayException;
import by.training.task03.customarray.entity.CustomArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomArraySortService {

    private static final ArrayValidator ARRAY_VALIDATOR = new ArrayValidator();
    private static final Logger logger = LogManager.getLogger(CustomArraySortService.class);

    /**
     * method sorts array in ascending order
     * exchange sort, time complexity - O(n^2)
     * @param array
     * @throws CustomArrayException
     */
    public void bubbleSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using bubble sort) array.");
        ARRAY_VALIDATOR.validateArray(array);

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

    /**
     * method sorts array in ascending order
     * insertion sort, time complexity - O(n^2)
     * @param array
     * @throws CustomArrayException
     */
    public void insertionSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using insertion sort) array.");
        ARRAY_VALIDATOR.validateArray(array);

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

    /**
     * method sorts array in ascending order
     * selection sort, time complexity - O(n^2)
     * @param array
     * @throws CustomArrayException
     */
    public void selectionSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using selection sort) array.");
        ARRAY_VALIDATOR.validateArray(array);

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

    /**
     * method sorts array in ascending order
     * improved bubble sort
     * exchange sort, time complexity - O(n^2)
     * @param array
     * @throws CustomArrayException
     */
    public void shakerSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using shaker sort) array.");
        ARRAY_VALIDATOR.validateArray(array);

        boolean isSorted = true;
        int left = 0;
        int right = array.size() - 1;

        do {
            isSorted = true;
            for(int i = left; i < right; i++) {
                int prev = array.atIndex(i);
                int next = array.atIndex(i + 1);

                if(prev > next) {
                    array.setAtIndex(i + 1, prev);
                    array.setAtIndex(i, next);
                    isSorted = false;
                }
            }
            right--;
            for(int i = right; i > left; i--) {
                int prev = array.atIndex(i - 1);
                int next = array.atIndex(i);

                if(prev > next) {
                    array.setAtIndex(i, prev);
                    array.setAtIndex(i - 1, next);
                    isSorted = false;
                }
            }
            left++;
        } while (isSorted == false);

        logger.info("Shaker sort method finished.");
    }

    /**
     * method sorts array in ascending order
     * improved selection sort(compare not only adjacent elements)
     * insertion sort, time complexity - O(n^2) in worst case
     * @param array
     * @throws CustomArrayException
     */
    public void shellSort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting (using shell sort) array.");
        ARRAY_VALIDATOR.validateArray(array);

        int j;
        int n = array.size();
        for(int step = n / 2; step > 0; step /= 2) {
            for(int i = step; i < n; i++) {
                int temp = array.atIndex(i);
                for (j = i; j >= step; j -= step) {
                    if(temp < array.atIndex(j - step)) {
                        array.setAtIndex(j, array.atIndex(j - step));
                    }
                    else {
                        break;
                    }
                }
                array.setAtIndex(j, temp);
            }
        }

        logger.info("Shell sort method finished.");
    }
}

