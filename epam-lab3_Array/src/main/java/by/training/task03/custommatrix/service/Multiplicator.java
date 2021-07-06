package by.training.task03.custommatrix.service;

import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;

public class Multiplicator {
    /**
     * @param A - matrix NxK
     * @param B - matrix KxM
     * @returns product of matrices A and B
     * @throws CustomMatrixException
     */
    public CustomMatrix multiply(CustomMatrix A, CustomMatrix B) throws CustomMatrixException {
        int rows = A.rows();
        int columns = B.columns();
        int controlSize = A.columns();
        if(controlSize != B.rows()) {
            throw new CustomMatrixException("Incompatible matrices");
        }
        CustomMatrix result = new CustomMatrix(rows, columns);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int value = 0;
                for(int k = 0; k < controlSize; k++) {
                    value += A.atIndex(i, k) * B.atIndex(k, j);
                }
                result.setAtIndex(i, j, value);
            }
        }
        return result;
    }
}
