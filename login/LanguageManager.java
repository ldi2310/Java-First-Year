package GiaoDien;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageManager {
    public static ResourceBundle messages;

    public static void setMessages(ResourceBundle messages) {
        LanguageManager.messages = messages;
    }

    public static String getMessage(String key) {
        if (messages != null) {
            try {
                return messages.getString(key);
            } catch (MissingResourceException e) {
                e.printStackTrace();
            }
        }
        return key; // Return the key if messages are not initialized
    }
}
