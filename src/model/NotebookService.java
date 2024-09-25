package model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.util.List;

public class NotebookService {
    private final Notebook model;

    public NotebookService(Notebook model) {
        this.model = model;
    }

    public void addNote(Note note) {
        model.addNote(note);
    }

    public List<Note> getNotesForDay(LocalDateTime dateTime) {
        return model.getNotesForDay(dateTime);
    }

    public List<Note> getNotesForWeek(LocalDateTime startOfWeek) {
        return model.getNotesForWeek(startOfWeek);
    }

    public void saveNotes(String fileName) throws IOException, IOException {
        model.saveToFile(fileName);
    }

    public void loadNotes(String fileName) throws IOException {
        model.loadFromFile(fileName);
    }

    public void showNotesForDay() {
    }

    public void showNotesForWeek() {

    }
}
