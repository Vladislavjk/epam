package by.training.task07.service;

import by.training.task07.bean.TextComponent;

public interface TextService {
    TextComponent sortParagraphsBySentenceCount(TextComponent textComponent);

    TextComponent sortWordsByLength(TextComponent textComponent);

    TextComponent sortTokensByFrequency(TextComponent textComponent, Character key);
}
