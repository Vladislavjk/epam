package by.training.task07.bean;

import java.util.List;

public class TextLeafLetter implements TextComponent {
    private Character letter;  // TODO fix to char

    public TextLeafLetter(Character character) {
        this.letter = character;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }  // TODO fix

    @Override
    public void setComponents(List<TextComponent> textComponents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public char getCharacter() {
       return letter;
    }

    @Override
    public boolean add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getComponent(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextLeafLetter that = (TextLeafLetter) o;
        return letter.equals(that.letter);
    }

    @Override
    public int hashCode() {
        int result = letter.hashCode();
        return result;
    }
}
