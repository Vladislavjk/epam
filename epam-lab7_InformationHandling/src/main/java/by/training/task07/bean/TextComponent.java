package by.training.task07.bean;

import java.util.List;

public interface TextComponent {
    List<TextComponent> getComponents();

    void setComponents(List<TextComponent> textComponents);

    char getCharacter();

    boolean add(TextComponent component);

    TextComponent getComponent(int index);

    boolean remove(TextComponent component);

    int getSize();

    String toString();
}
