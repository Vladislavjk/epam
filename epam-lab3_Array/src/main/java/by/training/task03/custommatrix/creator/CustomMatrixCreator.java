package by.training.task03.custommatrix.creator;

import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;
import by.training.task03.custommatrix.parser.MatrixParser;
import by.training.task03.custommatrix.reader.MatrixReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomMatrixCreator {

    private static final MatrixReader reader = new MatrixReader();
    private static final MatrixParser parser = new MatrixParser();

    private static final Logger logger = LogManager.getLogger(CustomMatrixCreator.class);

    public CustomMatrix createCustomMatrix(String fileName) throws CustomMatrixException {
        logger.info("Creating matrix entity from file {}.", fileName);

        List<String> data = reader.read(fileName);
        int[][] matrix = parser.parse(data);

        return new CustomMatrix(matrix);
    }
}

