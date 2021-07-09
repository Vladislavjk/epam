package by.training.task04.service.validator;

import by.training.task04.bean.Country;
import by.training.task04.dao.exception.DaoException;
import by.training.task04.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);

    public void validateCountry(Country country) throws ServiceException {
        if(country.getArea() <= 0) {
            throw new ServiceException("Validation error : area <= 0");
        }

        if(country.getRegions() == null || country.getRegions().size() == 0) {
            throw new ServiceException("Validation error : empty list of regions");
        }
    }

    public void validateList(List<String> list) throws ServiceException {
        if (list == null || list.size() == 0) {
            throw new ServiceException("Validation error: empty list.");
        }
    }

    public void validateFileName(String fileName) throws DaoException {
        if (fileName == null || fileName.length() == 0) {
            throw new DaoException("Validation error: filename is empty.");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            throw new DaoException("Validation error: file does not exist.");
        }
        if (file.length() == 0) {
            throw new DaoException("Validation error: file length is equal to 0.");
        }
    }
}
