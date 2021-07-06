package by.training.task03.custommatrix.validator;

import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class MatrixValidator {
    private static final Logger logger = LogManager.getLogger(MatrixValidator.class);

    public void validateMatrix(CustomMatrix matrix) throws CustomMatrixException {
        if(matrix == null || matrix.columns() == 0 || matrix.rows() == 0) {
            logger.error("Matrix cannot be empty.");
            throw new CustomMatrixException("Validation error: empty matrix.");
        }
    }

    public void validateList(List<String> list) throws CustomMatrixException {
        if (list == null || list.size() == 0) {
            logger.error("List cannot be empty.");
            throw new CustomMatrixException("Validation error: empty list.");
        }
    }

    public void validateFileName(String fileName) throws CustomMatrixException {
        if (fileName == null || fileName.length() == 0) {
            logger.error("File is not valid: filename is null.", fileName);
            throw new CustomMatrixException("Validation error: filename is empty.");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            logger.error("File {} is not valid: file does not exists.", fileName);
            throw new CustomMatrixException("Validation error: file does not exist.");
        }
        if (file.length() == 0) {
            logger.error("File {} is not valid: its length equal to 0.", fileName);
            throw new CustomMatrixException("Validation error: file length is equal to 0.");
        }
    }

}
