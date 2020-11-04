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
        model.accumulateWords(inputWord(scanner, Model.HELLO));
        model.accumulateWords(inputWord(scanner, Model.WORLD));
        view.printMessage(model.getPhrase());
    }

    private String inputWord(Scanner scanner, String expectedWord) {
        view.printMessage(String.format(View.INPUT, expectedWord));
        String actualWord = scanner.nextLine();
        while (!model.isCorrectWord(actualWord, expectedWord)) {
            view.printMessage(View.WRONG_INPUT + String.format(View.INPUT, expectedWord));
            actualWord = scanner.nextLine();
        }
        return actualWord;
    }

}

