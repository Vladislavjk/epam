package by.training.task05.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);

    public List<String> read(String inputFilePath) throws DaoException {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new DaoException("InputFile doesn't exist");
        }
        if (inputFile.length() == 0) {
            throw new DaoException("Your file is empty");
        }
        try (Stream<String> stream = Files.lines(Path.of(inputFilePath))) {  // TODO WTF IS HERE
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Errors in reading -> " + e.getMessage());
        }
        logger.info("The file -> {} was read,\tResult -> {}", inputFilePath, lines);
        return lines;
    }
}
