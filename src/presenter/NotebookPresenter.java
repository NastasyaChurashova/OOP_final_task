package presenter;

import model.Note;
import model.NotebookService;
import view.NotebookView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class NotebookPresenter {
    private final NotebookService notebookService;
    private final NotebookView view;

    public NotebookPresenter(NotebookService notebookService, NotebookView view) {
        this.notebookService = notebookService;
        this.view = view;
    }

    // The method to handle the running of the application
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.showMenu();
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine(); // Set the user's input to 'choice'
            handleUserChoice(choice); // Handle the input
            if (choice.equals("x")) break; // Exit when the user types 'x'
        }
        System.out.println("Exiting the program...");
    }

    private void handleUserChoice(String choice) {
        switch (choice) {
            case "1":
                addNote();
                break;
            case "2":
                showNotesForDay();
                break;
            case "3":
                showNotesForWeek();
                break;
            case "4":
                saveNotes();
                break;
            case "5":
                loadNotes();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                view.showInvalidChoice();
                break;
        }
    }

    public void addNote() {
        LocalDateTime dateTime = view.getDateTimeInput();
        String description = view.getDescriptionInput();
        Note newNote = new Note(dateTime, description);
        notebookService.addNote(newNote);
        view.showMessage("Note added.");
    }

    public void showNotesForDay() {
        LocalDateTime dateTime = view.getDateTimeInput();
        List<Note> notes = notebookService.getNotesForDay(dateTime);
        view.showNotes(notes);
    }

    public void showNotesForWeek() {
        LocalDateTime startOfWeek = view.getDateTimeInput();
        List<Note> notes = notebookService.getNotesForWeek(startOfWeek);
        if (notes.isEmpty()) {
            view.showMessage("No notes found for this week.");
        } else {
            view.showNotes(notes);
        }
    }

    public void saveNotes() {
        String fileName = view.getFileNameInput();
        try {
            notebookService.saveNotes(fileName);
            view.showMessage("Notes saved to: " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to save notes: " + e.getMessage());
        }
    }

    public void loadNotes() {
        String fileName = view.getFileNameInput();
        try {
            notebookService.loadNotes(fileName);
            view.showMessage("Notes loaded from: " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to load notes: " + e.getMessage());
        }
    }
}