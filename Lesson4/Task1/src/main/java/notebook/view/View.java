package notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Lera Melnychuk
 */
public class View {
    //Initialize constants
    private static final String whitespace = " ";
    // Resource Bundle Installation's
    private static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
            new Locale("ua", "UA"));
            //new Locale("ru", "RU"));
            //new Locale("en", "US"));
    /**
     * @param strings that will be concatenated
     * @return concatenated strings
     */
    public String concatenateStrings(String... strings) {
        StringBuilder concatStrings = new StringBuilder();
        for (String string : strings) {
            concatStrings.append(string);
            concatStrings.append(whitespace);
        }
        concatStrings.deleteCharAt(concatStrings.lastIndexOf(whitespace));
        return concatStrings.toString();
    }

    /**
     * @param message message that will be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * @param message message that will be printed after "input"
     */
    public void printInputMessage(String message) {
        printMessage(bundle.getString(TextConstants.INPUT) + message);
    }

    /**
     * @param message message that will be printed after message about wrong input
     */
    public void printWrongInputMessage(String message) {
        printMessage(bundle.getString(TextConstants.WRONG_INPUT));
        printInputMessage(message);
    }
}
