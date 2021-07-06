package by.training.task03;

import by.training.task03.customarray.entity.CustomArray;
import by.training.task03.customarray.exception.CustomArrayException;
import by.training.task03.customarray.service.CustomArraySortService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestShellSort {
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new int[]{2, 1, 0}, new int[]{0, 1, 2}},
                {new int[]{64, 75, 102}, new int[]{64, 75, 102}},
                {new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}},
                {new int[]{-1, -2, -3}, new int[]{-3, -2, -1}},
                {new int[]{1488, 1488}, new int[]{1488, 1488}},
                {new int[]{-7, 0}, new int[]{-7, 0}}
        };
    }

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void test(int input[], int[] expected) throws CustomArrayException {
        CustomArraySortService customArraySortService = new CustomArraySortService();
        CustomArray customArray = new CustomArray(input);
        customArraySortService.shellSort(customArray);
        int[] actual = customArray.getArrayCopy();
        assertEquals(actual, expected);
    }
}
