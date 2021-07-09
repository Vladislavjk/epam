package by.training.task04.service;

import by.training.task04.bean.Region;
import by.training.task04.service.impl.RegionServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class RegionServiceTest { // TODO more tests and empty
    @DataProvider(name = "allData")
    public Object[][] createData() {
        return new Object[][]{
                {new Region[]{new Region("Minsk Region"), new Region("Grodno Region")}, new String[]{"Minsk Region", "Grodno Region"}},
                {new Region[]{new Region("Omsk Region")}, new String[]{"Omsk Region"}},
                {new Region[]{new Region("")}, new String[]{""}}};
        };

    @Test(description = "Correct tests",
            dataProvider = "allData")
    public void getNamesTest(Region[] input, String[] expected) {
        RegionServiceImpl regionService = new RegionServiceImpl();
        String[] actual = regionService.getNames(new ArrayList<Region>(Arrays.asList(input))).toArray(new String[0]);
        assertEquals(actual, expected);
    }
}
