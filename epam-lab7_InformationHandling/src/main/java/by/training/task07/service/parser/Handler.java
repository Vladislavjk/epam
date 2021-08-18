package by.training.task07.service.parser;

import by.training.task07.bean.TextComponent;

@FunctionalInterface
public interface Handler {
    TextComponent handleRequest(String text);
}
