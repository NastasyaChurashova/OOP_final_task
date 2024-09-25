package view;
import model.Note;

import java.time.LocalDateTime;
import java.util.List;


public interface NotebookView {
    void showMenu();

    void showNotes(List<Note> notes);

    void showMessage(String message);

    String getDescriptionInput();

    String getFileNameInput();

    void showInvalidChoice();

    Note createNote();

   LocalDateTime getDateTimeInput();

    LocalDateTime dateTimeInput();
}
