package notebook.controller;

import notebook.view.View;

import java.util.Scanner;

import static notebook.view.TextConstants.ADD_MORE_OR_EXIT;
import static notebook.view.TextConstants.WRONG_INPUT;
import static notebook.view.View.bundle;

public class UtilityController {
    private Scanner scanner;
    private View view;

    public UtilityController(Scanner scanner, View view){
        this.scanner = scanner;
        this.view = view;
    }

    public String inputStringWithRegex(String message, String regex){
        view.printInputMessage(message);
        String string;
        while (!(scanner.hasNext() && (string = scanner.next()).matches(regex))){
            view.printWrongInputMessage(message);
        }
        return string;
    }


}
