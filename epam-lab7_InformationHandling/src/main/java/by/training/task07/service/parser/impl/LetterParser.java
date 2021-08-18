package by.training.task07.service.parser.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.bean.TextComposite;
import by.training.task07.bean.TextLeafLetter;
import by.training.task07.service.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterParser implements Handler {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent textComponent = new TextComposite();
        char[] letters = text.toCharArray();
        for (Character letter : letters) {  // TODO char and character
            textComponent.add(new TextLeafLetter(letter));
        }
        logger.info("Parse letter");
        return textComponent;
    }
}
