/**
 * The ZoomOutCommand class is a Java class that represents a command to zoom out in a perspective and
 * save the state using the Memento design pattern.
 */
package command;

import memento.Caretaker;
import modele.IPerspective;

public class ZoomOutCommand implements Command {
    private IPerspective choixPerspective;
    private double scaleFactor;
    private Caretaker caretaker;

    // The code snippet is the constructor of the `ZoomOutCommand` class. It takes
    // two parameters:
    // `choixPerspective` of type `IPerspective` and `scaleFactor` of type `double`.
    public ZoomOutCommand(IPerspective choixPerspective, double scaleFactor) {
        this.choixPerspective = choixPerspective;
        this.scaleFactor = scaleFactor;
        this.caretaker = Caretaker.getInstance();
    }

    /**
     * This function decreases the zoom factor of a perspective and saves its state.
     */
    @Override
    public void execute() {
        double currentZoom = this.choixPerspective.getZoomFactor();
        double newZoom = currentZoom / scaleFactor;
        choixPerspective.setZoomFactor(newZoom);
        caretaker.saveState(this.choixPerspective.saveToMemento(), choixPerspective.isFlag());
    }
}
