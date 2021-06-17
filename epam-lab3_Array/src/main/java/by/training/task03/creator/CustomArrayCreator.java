package by.training.task03.creator;

import by.training.task03.reader.Reader;
import by.training.task03.parser.Parser;
import by.training.task03.exception.CustomArrayException;
import by.training.task03.entity.CustomArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomArrayCreator {

    private static final Reader reader = new Reader();
    private static final Parser parser = new Parser();

    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public CustomArray createCustomArray(String fileName) throws CustomArrayException {
        logger.info("Creating array entity from file {}.", fileName);

        List<String> data = reader.read(fileName);
        int[] array = parser.parse(data);

        return new CustomArray(array);
    }
}

