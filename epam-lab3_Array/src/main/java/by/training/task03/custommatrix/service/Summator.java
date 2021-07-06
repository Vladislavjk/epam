package by.training.task03.custommatrix.service;

import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;

public class Summator {
    /**
     * @param A - matrix NxM
     * @param B - matrix NxM
     * @returns sum of matrices A and B
     * @throws CustomMatrixException
     */
    public CustomMatrix sum(CustomMatrix A, CustomMatrix B) throws CustomMatrixException {

        if(A.rows() != B.rows() || A.columns() != B.columns()) {
            throw new CustomMatrixException("Incompatible matrices");
        }
        CustomMatrix result = new CustomMatrix(A.rows(), A.columns());

        for(int i = 0; i < A.rows(); i++) {
            for(int j = 0; j < A.columns(); j++) {
                result.setAtIndex(i, j, A.atIndex(i, j) + B.atIndex(i, j));
            }
        }
        return result;
    }
}
