package by.training.task03.custommatrix.service;

import by.training.task03.custommatrix.entity.CustomMatrix;
import by.training.task03.custommatrix.exception.CustomMatrixException;

public class Transposer {
    /**
     * @param A - matrix NxM
     * @returns transposed matrix MxN
     * @throws CustomMatrixException
     */
    public CustomMatrix transpose(CustomMatrix A) throws CustomMatrixException {
        CustomMatrix result = new CustomMatrix(A.columns(), A.rows());
        for(int i = 0; i < A.rows(); i++) {
            for(int j = 0; j < A.columns(); j++) {
                result.setAtIndex(i, j, A.atIndex(j, i));
            }
        }
        return result;
    }
}
