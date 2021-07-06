package by.training.task03.customarray.validator;

import by.training.task03.customarray.entity.CustomArray;
import by.training.task03.customarray.exception.CustomArrayException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class ArrayValidator {

    private static final Logger logger = LogManager.getLogger(ArrayValidator.class);

    public void validateArray(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            logger.error("Array cannot be empty.");
            throw new CustomArrayException("Validation error: empty array.");
        }
    }
    public void validateList(List<String> list) throws CustomArrayException {
        if (list == null || list.size() == 0) {
            logger.error("List cannot be empty.");
            throw new CustomArrayException("Validation error: empty list.");
        }
    }
    public void validateFileName(String fileName) throws CustomArrayException {
        if (fileName == null || fileName.length() == 0) {
            logger.error("File is not valid: filename is null.", fileName);
            throw new CustomArrayException("Validation error: filename is empty.");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            logger.error("File {} is not valid: file does not exists.", fileName);
            throw new CustomArrayException("Validation error: file does not exist.");
        }
        if (file.length() == 0) {
            logger.error("File {} is not valid: its length equal to 0.", fileName);
            throw new CustomArrayException("Validation error: file length is equal to 0.");
        }
    }
}