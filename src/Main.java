import model.Notebook;
import model.NotebookService;
import view.ConsoleNotebookView;
import view.NotebookView;
import presenter.NotebookPresenter;

public class Main {
     public static void main(String[] args) {
          Notebook model = new Notebook();
          NotebookView view = new ConsoleNotebookView();
          NotebookService notebookService = new NotebookService(model);
          NotebookPresenter presenter = new NotebookPresenter(notebookService, view);

          presenter.run();
     }
}
