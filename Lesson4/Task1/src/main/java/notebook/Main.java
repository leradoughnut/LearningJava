package notebook;

import notebook.controller.Controller;
import notebook.model.Model;
import notebook.view.View;

public class Main {
    public static void main(String[] args){
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
