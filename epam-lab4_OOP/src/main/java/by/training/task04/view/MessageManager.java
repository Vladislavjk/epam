package by.training.task04.view;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    RU(ResourceBundle.getBundle("property.text", new Locale("ru", "RU"))),
    BY(ResourceBundle.getBundle("property.text", new Locale("be", "BY"))),
    DEFAULT(ResourceBundle.getBundle("property.text", new Locale("en", "US")));

    private ResourceBundle resourceBundle;

    MessageManager(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
