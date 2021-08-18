package by.training.task07.service.parser.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.bean.TextComposite;
import by.training.task07.service.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements Handler {
    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String REGEXP_SENTENCE_DELIMITER = "[!.?]";
    private Handler wordParser = new WordParser();

    @Override
    public TextComponent handleRequest(String text) {
        List<String> sentences = Arrays.stream(text.split(REGEXP_SENTENCE_DELIMITER)).collect(Collectors.toList());
        logger.info("Sentences parsed correctly ->\n{}", sentences);
        TextComponent textComposite = new TextComposite();

        for(String sentence : sentences) {
            if (sentence.length() > 0) {
                TextComponent componentSentence = wordParser.handleRequest(sentence);
                textComposite.add(componentSentence);
            }
        }
        return textComposite;
    }
}
