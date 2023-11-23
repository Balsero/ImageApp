/**
 * The Undo class is a command that allows the user to undo a previous action in a specific
 * perspective.
 */
package command;

import memento.Caretaker;
import modele.IPerspective;

public class Undo implements Command {

    private IPerspective choixPerspective;
    private Caretaker caretaker;

    // The code snippet is the constructor of the `Undo` class. It takes an
    // `IPerspective` object as a
    // parameter and assigns it to the `choixPerspective` instance variable. It also
    // initializes the
    // `caretaker` instance variable by calling the `getInstance()` method of the
    // `Caretaker` class.
    public Undo(IPerspective choixPerspective) {
        this.choixPerspective = choixPerspective;
        this.caretaker = Caretaker.getInstance();
    }

    /**
     * The execute function restores the state of the choixPerspective object from a
     * memento using the
     * undo method of the caretaker object.
     */
    @Override
    public void execute() {
        choixPerspective.restoreFromMemento(caretaker.undo(choixPerspective.isFlag()));
    }

}
