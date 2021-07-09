package by.training.task03.view;

import by.training.task03.customarray.creator.CustomArrayCreator;
import by.training.task03.customarray.entity.CustomArray;
import by.training.task03.customarray.exception.CustomArrayException;
import by.training.task03.customarray.service.CustomArraySortService;
import by.training.task03.custommatrix.creator.CustomMatrixCreator;
import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;
import by.training.task03.custommatrix.service.Multiplicator;
import by.training.task03.custommatrix.service.Subtractor;
import by.training.task03.custommatrix.service.Summator;
import by.training.task03.custommatrix.service.Transposer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws CustomArrayException, CustomMatrixException {
        CustomArrayCreator cac = new CustomArrayCreator();
        CustomMatrixCreator cmc = new CustomMatrixCreator();
        CustomArraySortService cass = new CustomArraySortService();
        Summator summator = new Summator();
        Subtractor subtractor = new Subtractor();
        Multiplicator multiplicator = new Multiplicator();
        Transposer transposer = new Transposer();
        try {
            CustomArray array1 = cac.createCustomArray("input_array1.txt");
            CustomArray array2 = cac.createCustomArray("input_array2.txt");
            CustomArray array3 = cac.createCustomArray("input_array3.txt");
            CustomArray array4 = cac.createCustomArray("input_array4.txt");
            CustomArray array5 = cac.createCustomArray("input_array5.txt");


            System.out.println("Array before bubble sort : " + array1);
            cass.bubbleSort(array1);
            System.out.println("Array after bubble sort : " + array1);
            System.out.println("Array before insertion sort : " + array2);
            cass.insertionSort(array2);
            System.out.println("Array after insertion sort : " + array2);
            System.out.println("Array before selection sort : " + array3);
            cass.selectionSort(array3);
            System.out.println("Array after selection sort : " + array3);
            System.out.println("Array before shaker sort : " + array4);
            cass.shakerSort(array4);
            System.out.println("Array after shaker sort : " + array4);
            System.out.println("Array before shell sort : " + array5);
            cass.shellSort(array5);
            System.out.println("Array after shell sort : " + array5);
        }
        catch (CustomArrayException e) {
            logger.error(e.getMessage());
        }

        try {
            CustomMatrix matrix1 = cmc.createCustomMatrix("input_matrix1.txt");
            CustomMatrix matrix2 = cmc.createCustomMatrix("input_matrix2.txt");
            System.out.println("First matrix : " + matrix1);
            System.out.println("Second matrix : " + matrix2);
            System.out.println("Matrix sum : " + summator.sum(matrix1, matrix2));
            System.out.println("Matrix subtraction : " + subtractor.subtract(matrix1, matrix2));
            System.out.println("Matrix multiplication : " + multiplicator.multiply(matrix1, matrix2));
            System.out.println("Transposed first matrix : " + transposer.transpose(matrix1));
        }
        catch (CustomMatrixException e) {
            logger.error(e.getMessage());
        }
    }
}
