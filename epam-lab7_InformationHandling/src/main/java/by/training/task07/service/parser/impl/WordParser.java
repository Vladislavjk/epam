package by.training.task07.service.parser.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.bean.TextComposite;
import by.training.task07.bean.TextLeafPunctuation;
import by.training.task07.service.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements Handler {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_LEXEME_DETECT = "[а-яА-Я()&~|><'”^\\w]+[,.?!-]";
    private static final String REGEXP_LEXEME_DELIMITER = "\\s";
    private static final String REGEXP_WORD_DELIMITER = "[а-яА-Я()&~|><'”^\\w]+";
    private Handler letterParser = new LetterParser();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent textComponent = new TextComposite();
        String[] lexemes = text.split(REGEXP_LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            if (lexeme.matches(REGEXP_WORD_DELIMITER)) {
                logger.info("Detect word -> {}\nRequest sent to letter parser", lexeme);
                TextComponent componentWord = letterParser.handleRequest(lexeme);
                textComponent.add(componentWord);
            } else if (lexeme.matches(REGEXP_LEXEME_DETECT)) {
                logger.info("Detect lexeme -> {}\nRequest sent to letter parser", lexeme);
                textComponent.add(letterParser.handleRequest(lexeme.substring(0, lexeme.length() - 1)));
                textComponent.add(new TextLeafPunctuation(lexeme.charAt(lexeme.length() - 1)));
            } else {
                if (lexeme.length() > 0) {
                    textComponent.add(new TextLeafPunctuation(lexeme.charAt(lexeme.length() - 1)));
                }
            }
        }
        return textComponent;
    }
}
