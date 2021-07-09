package by.training.task04.service.creator;

import by.training.task04.bean.Country;
import by.training.task04.dao.exception.DaoException;
import by.training.task04.service.exception.ServiceException;
import by.training.task04.service.parser.Parser;
import by.training.task04.dao.reader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CountryCreator {
    private static final Logger logger = LogManager.getLogger(CountryCreator.class);

    private static final Reader reader = new Reader();
    private static final Parser parser = new Parser();

    public Country createCountry(String fileName) throws ServiceException{
        logger.info("Creating array entity from file {}.", fileName);

        try {
            List<String> data = reader.read(fileName);
            return parser.parse(data);
        }catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
