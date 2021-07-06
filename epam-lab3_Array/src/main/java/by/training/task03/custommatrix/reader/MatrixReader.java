package by.training.task03.custommatrix.reader;

import by.training.task03.custommatrix.creator.CustomMatrixCreator;
import by.training.task03.custommatrix.exception.CustomMatrixException;
import by.training.task03.custommatrix.validator.MatrixValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MatrixReader {
    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();
    private static final Logger logger = LogManager.getLogger(CustomMatrixCreator.class);

    public MatrixReader() { }

    public List<String> read(String fileName) throws CustomMatrixException {
        logger.info("Reading from file {}.", fileName);
        MATRIX_VALIDATOR.validateFileName(fileName);

        try {
            return Files.readAllLines(new File(fileName).toPath());  // TODO WHY IS THIS WORKING
        } catch (IOException e) {
            logger.error("Reading from file {} failed.", fileName);
            throw new CustomMatrixException(e);
        }
    }
}
