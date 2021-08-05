package by.training.task05.service.parser;

import by.training.task05.bean.Point2D;
import by.training.task05.service.exception.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger();
    public static final String FOR_SPLIT_REGEX = "\\s";

    public List<Point2D> parseValidPointsToCreate(String line) throws ParseException {
        List<Point2D> pointListToCreate = new ArrayList<>();
        String[] coordinates = line.split(FOR_SPLIT_REGEX);
        for (int i = 0; i < coordinates.length; i += 2) {
            try {
                pointListToCreate.add(new Point2D(Double.parseDouble(coordinates[i]), Double.parseDouble(coordinates[i + 1])));
            } catch (NumberFormatException e) {
                throw new ParseException(e);
            }
        }
        return pointListToCreate;
    }
}
