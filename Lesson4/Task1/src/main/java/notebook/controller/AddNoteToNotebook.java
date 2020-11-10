package notebook.controller;

import notebook.model.Model;
import notebook.model.NotebookException;
import notebook.view.View;

import java.util.Scanner;

import static notebook.model.RegExpConstants.*;
import static notebook.view.TextConstants.*;

public class AddNoteToNotebook {
    private Scanner scanner;
    private View view;
    private Model model;

    public AddNoteToNotebook(Scanner scanner, View view, Model model){
        this.scanner = scanner;
        this.view = view;
        this.model = model;
    }

    public void inputNote(){
        UtilityController utilityController = new UtilityController(scanner, view);
        String firstName = utilityController.inputStringWithRegex(getString(FIRST_NAME), regexForName());
        String lastName = utilityController.inputStringWithRegex(getString(LAST_NAME), regexForName());
        while(true){
            try{
                String email = utilityController.inputStringWithRegex(getString(EMAIL), EMAIL_ALL);
                model.addNoteToNotebook(firstName, lastName, email);
                return;

            }catch (NotebookException notebookException){
                notebookException.printStackTrace();
            }
        }

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
