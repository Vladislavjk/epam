package by.training.task05.validator;

import by.training.task05.service.validator.ToCreateTriangleValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ToCreateTriangleValidatorTest {
    List<String> linesForValidation = Arrays.asList("1 2.4 -3.4 5 5.3 -7", "4 2.4 3.4 5 94aaaaaaa.3 7");
    static ToCreateTriangleValidator validator;

    @BeforeClass
    public static void initialize() {
        validator = new ToCreateTriangleValidator();
    }

    @Test
    public void validateTest() {
        List<String> actualValidationResult = validator.validate(linesForValidation);
        List<String> expectedValidationResult = Arrays.asList("1 2.4 -3.4 5 5.3 -7");
        assertEquals(actualValidationResult, expectedValidationResult);
    }

    @AfterClass
    public static void clear() {
        validator = null;
    }
}
