package by.training.task03.entity;

import java.util.Arrays;
import by.training.task03.exception.CustomArrayException;

public class CustomArray {
    private int[] array;

    public CustomArray() { }

    public CustomArray(int ... array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArrayCopy() {
        return Arrays.copyOf(array, array.length);
    }

    public int atIndex(int index) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index is out of bounds.");
        }
        return array[index];
    }

    public void setAtIndex(int index, int value) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index is out of bounds.");
        }
        array[index] = value;
    }

    public int size() { return array.length; }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (toCompare == null || toCompare.getClass() != this.getClass()) {
            return false;
        }

        return Arrays.equals(array, ((CustomArray) toCompare).array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
