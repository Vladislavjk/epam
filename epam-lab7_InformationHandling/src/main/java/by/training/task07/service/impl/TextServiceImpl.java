package by.training.task07.service.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.bean.TextComposite;
import by.training.task07.bean.TextLeafPunctuation;
import by.training.task07.service.TextService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class TextServiceImpl implements TextService {
    private static final Logger logger = LogManager.getLogger(TextServiceImpl.class);

    @Override
    public TextComponent sortParagraphsBySentenceCount(TextComponent text) {
        List<TextComponent> paragraphList = text.getComponents();
        paragraphList.sort(Comparator.comparing(TextComponent::getSize));
        logger.info("Sort Paragraphs By Sentence Count complete\n");
        return new TextComposite(paragraphList);
    }

    @Override  // TODO can't skip some components
    public TextComponent sortWordsByLength(TextComponent textComponent) {
        List<TextComponent> paragraphsList = textComponent.getComponents();
        for(TextComponent paragraph : paragraphsList) {
            List<TextComponent> sentences = paragraph.getComponents();
            for(TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();
                words.sort(Comparator.comparing(TextComponent::getSize));
                sentence.setComponents(words);
            }
        }
        return textComponent;
    }

    @Override
    public TextComponent sortTokensByFrequency(TextComponent textComponent, Character key) {
        List<TextComponent> paragraphsList = textComponent.getComponents();
        for(TextComponent paragraph : paragraphsList) {
            List<TextComponent> sentences = paragraph.getComponents();
            for(TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();
                words.sort(Comparator.comparing((textComponentLetters -> amountOfChars((TextComponent) textComponentLetters, key))).reversed());
                sentence.setComponents(words);
            }
        }
        return textComponent;
    }

    private long amountOfChars(TextComponent word, Character key) {
        //return s.chars().filter(c -> c == key).count();
        if(word instanceof TextLeafPunctuation) {  // костыль
            return word.getCharacter() == key ? 1 : 0;
        } else {
            List<TextComponent> letters = word.getComponents();
            long cnt = 0;
            for(TextComponent letter : letters) {
                if(letter.getCharacter() == key) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
