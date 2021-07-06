package by.training.task03.customarray.parser;

import by.training.task03.customarray.creator.CustomArrayCreator;
import by.training.task03.customarray.validator.ArrayValidator;
import by.training.task03.customarray.exception.CustomArrayException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ArrayParser {

    private final Pattern pattern = Pattern.compile("^(-?\\d+, )+$");

    private static final ArrayValidator ARRAY_VALIDATOR = new ArrayValidator();
    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public ArrayParser() { }

    public int[] parse(List<String> list) throws CustomArrayException {
        logger.info("Parsing list of file lines.");
        ARRAY_VALIDATOR.validateList(list);

        int[] array = list.stream()
                .map(it -> it + ", ")
                .filter(line -> pattern.matcher(line).matches())
                .flatMap(line -> Arrays.stream(line.split(", ")))
                .mapToInt(Integer::parseInt)
                .toArray();

        logger.info("Parsing list of file lines was successfully finished.");
        return array;
    }
}