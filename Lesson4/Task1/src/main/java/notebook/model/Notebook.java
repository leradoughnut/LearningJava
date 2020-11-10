package notebook.model;

import java.util.ArrayList;
import java.util.List;
import notebook.view.TextConstants;
import notebook.view.View;
import notebook.view.View.*;

public class Notebook {
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) throws NotebookException {
        if (notes.stream().anyMatch(n -> n.getEmail().equals(note.getEmail()))){
            throw new NotebookException(View.bundle.getString(TextConstants.USER_WITH_THIS_EMAIL_ALREADY_EXIST));
        }
        notes.add(note);
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Note note : notes){
            builder.append(note.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
