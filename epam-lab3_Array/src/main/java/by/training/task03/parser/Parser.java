package by.training.task03.parser;

import by.training.task03.validator.Validator;
import by.training.task03.exception.CustomArrayException;
import by.training.task03.creator.CustomArrayCreator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private final Pattern pattern = Pattern.compile("^(-?\\d+, )+$");

    private static final Validator validator = new Validator();
    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public Parser() { }

    public int[] parse(List<String> list) throws CustomArrayException {
        logger.info("Parsing list of file lines.");
        validator.validateList(list);

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