package notebook.controller;

import notebook.view.View;

import java.util.Scanner;

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
