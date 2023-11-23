/**
 * The Redo class is a command that restores the state of a perspective object from a memento and
 * prints the zoom factor.
 */
package command;

import memento.Caretaker;
import modele.IPerspective;

public class Redo implements Command {

    private IPerspective choixPerspective;
    private Caretaker caretaker;

    // The `public Redo(IPerspective choixPerspective)` constructor is initializing
    // the
    // `choixPerspective` and `caretaker` variables of the `Redo` class.
    public Redo(IPerspective choixPerspective) {
        this.choixPerspective = choixPerspective;
        this.caretaker = Caretaker.getInstance();
    }

    /**
     * The execute function restores the state of a perspective object from a
     * memento and prints the
     * zoom factor.
     */
    @Override
    public void execute() {
        choixPerspective.restoreFromMemento(caretaker.redo(this.choixPerspective.isFlag()));
        System.out.println(this.choixPerspective.getZoomFactor());
    }

}
