package notebook.controller;

import notebook.model.Model;
import notebook.view.View;

import static notebook.view.TextConstants.*;
import static notebook.model.RegExpConstants.*;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);
        inputNote(scanner);
        view.printMessage(model.getNotebook());
    }

    private void inputNote(Scanner scanner){
        UtilityController utilityController = new UtilityController(scanner, view);
        String firstName = utilityController.inputStringWithRegex(getString(FIRST_NAME), regexForName());
        String lastName = utilityController.inputStringWithRegex(getString(LAST_NAME), regexForName());
        String email = utilityController.inputStringWithRegex(getString(EMAIL), EMAIL_ALL);
        model.addNoteToNotebook(firstName, lastName, email);
    }

    private String regexForName(){
        String regex;
        switch (getLanguage()) {
            case "ua":
                regex =NAME_UA;
                break;
            case "ru":
                regex = NAME_RU;
                break;
            case "en":
                regex = NAME_EN;
                break;
            default:
                regex = "";
        }
        return regex;
    }

    private String getLanguage() {
        return View.bundle.getLocale().getLanguage();
    }

    private String getString(String message){
        return View.bundle.getString(message);
    }
}
