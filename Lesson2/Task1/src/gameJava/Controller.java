package gameJava;

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
        greetings();
        int number = enteringTheNumberInBounds(scanner);
        while (!isNumberGuessed(number)) {
            number = enteringTheNumberInBounds(scanner);
        }
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

    private boolean isNumberGuessed(int number) {
        model.addAttempt(number);
        if (model.isGreaterThan(number)) {
            view.printMessage(View.GREATER);
            model.setLeftBound(number);
        } else if (model.isLessThan(number)) {
            view.printMessage(View.LESS);
            model.setRightBound(number);
        } else {
            view.printMessage(View.GUESSED);
            return true;
        }
        return false;
    }

    private void summary() {
        view.printMessage(String.format(View.SUMMARY, model.getPickedNumber(), model.getAttempts().size(),
                model.getAttempts()));
    }

}
