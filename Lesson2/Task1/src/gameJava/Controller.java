package gameJava;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setLeftBound(GlobalConstants.PRIMARY_MIN_BARRIER);
        model.setRightBound(GlobalConstants.PRIMARY_MAX_BARRIER);
        model.pickNumber();
        greetings();
        while (!isGuessedOrLessOrGreater(enteringTheNumberInBounds(scanner))) ;
        summary();
    }

    private void greetings() {
        view.printMessage(String.format(View.GREETING, model.getLeftBound(), model.getRightBound()));
    }

    private int enteringTheNumberInBounds(Scanner scanner) {
        int number = enteringTheNumber(scanner);
        while (!model.isNumberInBounds(number)) {
            view.printMessage(String.format(View.NOT_IN_BOUNDS, number));
            number = enteringTheNumber(scanner);
        }
        return number;
    }

    private int enteringTheNumber(Scanner scanner) {
        String formattedInvite = String.format(View.INVITE, model.getLeftBound(), model.getRightBound());
        view.printMessage(formattedInvite);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.NOT_A_NUMBER + formattedInvite);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean isGuessedOrLessOrGreater(int number) {
        if (model.isNumberGuessed(number)) {
            view.printMessage(View.GUESSED);
            return true;
        } else {
            if (model.getLeftBound() == number)
                view.printMessage(View.GREATER);
            else view.printMessage(View.LESS);
        }
        return false;
    }

    private void summary() {
        List<Integer> attempts = model.getAttempts();
        view.printMessage(String.format(View.SUMMARY, attempts.get(attempts.size() - 1), attempts.size(), attempts));
    }

}
