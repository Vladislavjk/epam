package by.training.task03.customarray.service;

import by.training.task03.customarray.entity.CustomArray;
import by.training.task03.customarray.exception.CustomArrayException;
import by.training.task03.customarray.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArraySortServiceStream {

    private final ArrayValidator arrayValidator = new ArrayValidator();
    private static final Logger logger = LogManager.getLogger(CustomArraySortServiceStream.class);

    public CustomArray sort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting array (stream api).");
        arrayValidator.validateArray(array);

        int[] arrayCopy = array.getArrayCopy();
        Arrays.stream(arrayCopy).sorted();

        return new CustomArray(arrayCopy);
    }
}

