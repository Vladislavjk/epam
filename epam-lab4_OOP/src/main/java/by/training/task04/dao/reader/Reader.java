package by.training.task04.dao.reader;

import by.training.task04.dao.exception.DaoException;
import by.training.task04.service.creator.CountryCreator;
import by.training.task04.service.exception.ServiceException;
import by.training.task04.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Reader {
    private static final Logger logger = LogManager.getLogger(CountryCreator.class);
    public static final Validator validator = new Validator();

    public Reader() { }

    public List<String> read(String fileName) throws DaoException{
        logger.info("Reading from file {}.", fileName);
        validator.validateFileName(fileName);

        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new DaoException("Reading from file failed.", e);
        }
    }
}
