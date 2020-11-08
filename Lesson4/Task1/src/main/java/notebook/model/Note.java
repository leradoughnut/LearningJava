package notebook.model;

import notebook.view.View;

public class Note {
    private String firstName;
    private String lastName;
    private String email;

    public Note(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private static String getLocale() {
        return View.bundle.getLocale().getLanguage();
    }

    public static boolean isValidName(String name) {
        String regex;
        switch (getLocale()) {
            case "ua":
                regex = RegExpConstants.NAME_UA;
                break;
            case "ru":
                regex = RegExpConstants.NAME_RU;
                break;
            case "en":
                regex = RegExpConstants.NAME_EN;
                break;
            default:
                regex = "";
        }
        return name.matches(regex);
    }

    public static boolean isValidEmail(String email) {
        return email.matches(RegExpConstants.EMAIL);
    }

    @Override
    public String toString(){
        String whitespace = " ";
        return firstName + whitespace + lastName + whitespace + email;
    }
}
