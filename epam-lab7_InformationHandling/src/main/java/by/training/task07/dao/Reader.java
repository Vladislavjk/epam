package by.training.task07.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);

    public String read(String inputFilePath) throws DaoException {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new DaoException("InputFile doesn't exist");
        }
        if (inputFile.length() == 0) {
            throw new DaoException("Your file is empty");
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line); // append("\n") not needed
            }
        } catch (IOException e) {
            throw new DaoException("Errors in reading -> " + e.getMessage());
        }
        logger.info("The file -> {} was read,\tResult ->\n{}", inputFilePath, stringBuilder);
        return stringBuilder.toString();
    }
}
