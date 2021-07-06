package by.training.task03.customarray.creator;

import by.training.task03.customarray.entity.CustomArray;
import by.training.task03.customarray.reader.ArrayReader;
import by.training.task03.customarray.parser.ArrayParser;
import by.training.task03.customarray.exception.CustomArrayException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomArrayCreator {

    private static final ArrayReader reader = new ArrayReader();
    private static final ArrayParser parser = new ArrayParser();

    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public CustomArray createCustomArray(String fileName) throws CustomArrayException {
        logger.info("Creating array entity from file {}.", fileName);

        List<String> data = reader.read(fileName);
        int[] array = parser.parse(data);

        return new CustomArray(array);
    }
}

