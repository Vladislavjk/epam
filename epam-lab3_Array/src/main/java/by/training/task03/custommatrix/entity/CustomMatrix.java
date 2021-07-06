package by.training.task03.custommatrix.entity;

import by.training.task03.custommatrix.exception.CustomMatrixException;

import java.util.Arrays;

public class CustomMatrix {
    private int[][] matrix;

    public CustomMatrix() { }

    public CustomMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public CustomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        this.matrix = matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrixCopy() {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++)
            result[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        return result;
    }

    public int atIndex(int i, int j) throws CustomMatrixException {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            throw new CustomMatrixException("Index is out of bounds.");
        }
        return matrix[i][j];
    }

    public void setAtIndex(int i, int j, int value) throws CustomMatrixException {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            throw new CustomMatrixException("Index is out of bounds.");
        }
        matrix[i][j] = value;
    }

    public int rows() { return matrix.length; }

    public int columns() { return matrix[0].length; }

    @Override
    public int hashCode() {
        return matrix.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof CustomMatrix) {
            CustomMatrix node = (CustomMatrix) o;
            int[][] matrix1 = this.getMatrixCopy();
            int[][] matrix2 = node.getMatrixCopy();
            return Arrays.deepEquals(matrix1, matrix2);
        }
        return false;
    }

    @Override
    public String toString() { // TODO SIMPLIFY
        String result = "[";
        for(int i = 0; i < rows(); i++) {
            result += Arrays.toString(matrix[i]);
            if(i != rows() - 1) {
                result += ", ";
            }
        }
        return result + ']';
    }
}
