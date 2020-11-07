package notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Lera Melnychuk
 */
public class View {
    static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
            new Locale("ua", "UA"));
            //new Locale("ru", "RU"));
            //new Locale("en", "US"));

    /**
     *
     * @param message message that will be printed
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     *
     * @param message message that will be printed after "input"
     */
    public void printInputMessage(String message){
        printMessage(bundle.getString(TextConstants.INPUT) + message);
    }

    /**
     *
     * @param message message that will be printed after message about wrong input
     */
    public void printWrongInputMessage(String message){
        printMessage(bundle.getString(TextConstants.WRONG_INPUT));
        printInputMessage(message);
    }
}
