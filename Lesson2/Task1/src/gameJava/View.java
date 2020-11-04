package gameJava;

public class View {
    public static final String GREETING = "Hi! Now you are playing the game. Computer picks" +
            " a random number between %s and %s and you have to guess it";
    public static final String INVITE = "Please enter the number between %s and %s:";
    public static final String NOT_A_NUMBER = "It's not a number, repeat please. ";
    public static final String NOT_IN_BOUNDS = "You entered a number %s that is not in bounds. ";

    public static final String GREATER = "Greater! ";
    public static final String LESS = "Less! ";
    public static final String GUESSED = "Yeah! You've guessed it! Congratulations!";
    public static final String SUMMARY = "You've guessed the number %s in %s attempts. You options were %s";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
