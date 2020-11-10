package notebook.controller;

import notebook.model.Model;
import notebook.view.View;

import static notebook.view.TextConstants.*;
import static notebook.view.View.bundle;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        AddNoteToNotebook addNote = new AddNoteToNotebook(scanner, view, model);
        addNote.inputNote();
        view.printMessage(bundle.getString(SUCCESS));
        while(continueOrNot(scanner)){
            addNote.inputNote();
            view.printMessage(bundle.getString(SUCCESS));
        }
        view.printMessage(bundle.getString(ALL_USERS));
        view.printMessage(model.getNotebook());
    }

    public boolean continueOrNot(Scanner scanner){
        view.printMessage(bundle.getString(ADD_MORE_OR_EXIT));
        while (scanner.hasNext()){
            String continueOrExit = scanner.next();
            if (continueOrExit.equals("exit"))
                return false;
            else if (continueOrExit.equals("continue"))
                return true;
            view.printMessage(view.concatenateStrings(bundle.getString(WRONG_INPUT), bundle.getString(ADD_MORE_OR_EXIT)));
        }
        return false;
    }
}
