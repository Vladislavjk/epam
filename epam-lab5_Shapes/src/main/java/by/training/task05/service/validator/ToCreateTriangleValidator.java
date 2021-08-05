package by.training.task05.service.validator;

import java.util.ArrayList;
import java.util.List;

public class ToCreateTriangleValidator {
    public static final String IS_POINT_REGEX = "(^-?(\\d*)(\\.?\\d*))";  // TODO WTF IS THIS REGEX
    public static final String FOR_SPLIT_REGEX = "\\s";
    public static final int CORRECT_LENGTH = 6;

    public List<String> validate(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            if(isDataValidForTriangle(line)) {
                validLines.add(line);
            }
        }
        return validLines;
    }

    private boolean isDataValidForTriangle(String line) {
        boolean flag = false;
        String[] coordinates = line.split(FOR_SPLIT_REGEX);
        if(isLineValid(coordinates)) {
            flag = true;
            for (String coordinate : coordinates) {
                if (!isPointValid(coordinate)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean isPointValid(String number) {
        return number.matches(IS_POINT_REGEX);
    }

    private boolean isLineValid(String[] coordinates) {
        return (coordinates.length == CORRECT_LENGTH);
    }
}
