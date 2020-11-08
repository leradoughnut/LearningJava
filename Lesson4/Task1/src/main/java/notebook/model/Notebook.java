package notebook.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note){
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
