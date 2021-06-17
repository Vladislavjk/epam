package by.training.task03.service;

import by.training.task03.validator.Validator;
import by.training.task03.exception.CustomArrayException;
import by.training.task03.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArraySortServiceStream {

    private final Validator validator = new Validator();
    private static final Logger logger = LogManager.getLogger(CustomArraySortServiceStream.class);

    public CustomArray sort(CustomArray array) throws CustomArrayException {
        logger.info("Sorting array (stream api).");
        validator.validateArray(array);

        int[] arrayCopy = array.getArrayCopy();
        Arrays.stream(arrayCopy).sorted();

        return new CustomArray(arrayCopy);
    }
}

