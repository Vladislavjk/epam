package by.training.task03.customarray.reader;

import by.training.task03.customarray.creator.CustomArrayCreator;
import by.training.task03.customarray.exception.CustomArrayException;
import by.training.task03.customarray.validator.ArrayValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ArrayReader {

    private static final ArrayValidator ARRAY_VALIDATOR = new ArrayValidator();
    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public ArrayReader() { }

    public List<String> read(String fileName) throws CustomArrayException {
        logger.info("Reading from file {}.", fileName);
        ARRAY_VALIDATOR.validateFileName(fileName);

        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            logger.error("Reading from file {} failed.", fileName);
            throw new CustomArrayException(e);
        }
    }
}
