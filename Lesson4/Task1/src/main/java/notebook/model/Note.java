package notebook.model;

public class Note {
    private String firstName;
    private String lastName;
    private String email;

    public Note(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String whitespace = " ";
        return firstName + whitespace + lastName + whitespace + email;
    }
}
