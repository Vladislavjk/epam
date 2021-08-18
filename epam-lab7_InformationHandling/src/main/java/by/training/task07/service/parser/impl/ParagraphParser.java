package by.training.task07.service.parser.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.bean.TextComposite;
import by.training.task07.service.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements Handler {
    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private static final String REGEXP_PARAGRAPH_DELIMITER = "\\s{4}";
    private Handler sentenceParser = new SentenceParser();  // TODO fix chain of responsibilities(initialize in service and skip)

    @Override
    public TextComponent handleRequest(String text) {
        List<String> paragraphs = Arrays.stream(text.split(REGEXP_PARAGRAPH_DELIMITER)).collect(Collectors.toList());
        logger.info("Paragraphs parsed correctly ->\n{}", paragraphs);
        TextComponent textComposite = new TextComposite();

        for(String paragraph : paragraphs) {
            if (paragraph.length() > 0) {
                TextComponent componentParagraph = sentenceParser.handleRequest(paragraph);
                textComposite.add(componentParagraph);
            }
        }
        return textComposite;
    }
}
