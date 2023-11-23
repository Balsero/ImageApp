/**
 * The Translate class is a command that moves an object in a perspective by a given delta.
 */
package command;

import java.awt.Point;
import memento.Caretaker;
import modele.IPerspective;

public class Translate implements Command {

    private IPerspective choixPerspective;
    private Point delta;
    private Caretaker caretaker;

    // The code snippet is the constructor of the `Translate` class. It initializes
    // the
    // `choixPerspective` and `delta` variables with the values passed as arguments
    // to the constructor.
    // It also initializes the `caretaker` variable by calling the `getInstance()`
    // method of the
    // `Caretaker` class.
    public Translate(IPerspective choixPerspective, Point delta) {
        this.choixPerspective = choixPerspective;
        this.delta = delta;
        this.caretaker = Caretaker.getInstance();
    }

    /**
     * The function updates the position of a perspective based on a given delta.
     */
    @Override
    public void execute() {
        if (choixPerspective.getPosition() != null) {
            Point currentPos = choixPerspective.getPosition();
            Point newPos = new Point(currentPos.x + delta.x, currentPos.y + delta.y);
            choixPerspective.setPosition(newPos);
        }
    }
}
