package by.training.task03.reader;

import by.training.task03.exception.CustomArrayException;
import by.training.task03.validator.Validator;
import by.training.task03.creator.CustomArrayCreator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Reader {

    private static final Validator validator = new Validator();
    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public Reader() { }

    public List<String> read(String fileName) throws CustomArrayException {
        logger.info("Reading from file {}.", fileName);
        validator.validateFileName(fileName);

        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            logger.error("Reading from file {} failed.", fileName);
            throw new CustomArrayException(e);
        }
    }
}
