package by.training.task03.custommatrix.parser;

import by.training.task03.custommatrix.exception.CustomMatrixException;
import by.training.task03.custommatrix.validator.MatrixValidator;
import by.training.task03.custommatrix.creator.CustomMatrixCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class MatrixParser {
    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();
    private static final Logger logger = LogManager.getLogger(CustomMatrixCreator.class);

    public MatrixParser() { }

    public int[][] parse(List<String> list) throws CustomMatrixException {
        logger.info("Parsing list of file lines.");
        MATRIX_VALIDATOR.validateList(list);

       /* int[][] array = list.stream()  // TODO PARSE MATRIX AND DEAL WITH STREAMS
                .map(it -> it + ", ")
                .filter(line -> pattern.matcher(line).matches())
                .flatMap(line -> Arrays.stream(line.split(", ")))
                .mapToInt(Integer::parseInt)
                .toArray();

        logger.info("Parsing list of file lines was successfully finished.");
        return array;*/

        int[][] matrix = new int[list.size()][list.get(0).split(" ").length];
        for(int i = 0; i < matrix.length; i++) {
            String[] child = list.get(i).split(" ");
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(child[j]);
            }
        }

        logger.info("Parsing list of file lines was successfully finished.");
        return matrix;
        /*for(String next : list) {
            //String[] child = next.split(" ");
            for(String element : next.split(" ")) {

            }
        }*/

        //return new int[][]{{1, 1}, {2, 2}};
    }
}
