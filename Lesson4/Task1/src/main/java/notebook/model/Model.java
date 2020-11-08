package notebook.model;

public class Model {
    private Notebook notebook = new Notebook();

    public void addNoteToNotebook(String firstName, String lastName, String email) {
        notebook.addNote(new Note(firstName, lastName, email));
    }

    public String getNotebook() {
        return notebook.toString();
    }
}
