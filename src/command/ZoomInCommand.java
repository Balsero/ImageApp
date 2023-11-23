/**
 * The ZoomInCommand class is a Java class that represents a command to zoom in on a perspective.
 */
package command;

import memento.Caretaker;
import modele.IPerspective;

public class ZoomInCommand implements Command {

    private IPerspective choixPerspective;
    private double scaleFactor;
    private Caretaker caretaker;

    // The code snippet you provided is the constructor of the `ZoomInCommand`
    // class. It takes two
    // parameters: `choixPerspective` of type `IPerspective` and `scaleFactor` of
    // type `double`.
    public ZoomInCommand(IPerspective choixPerspective, double scaleFactor) {
        this.choixPerspective = choixPerspective;
        this.scaleFactor = scaleFactor;
        this.caretaker = Caretaker.getInstance();
    }

    /**
     * This function updates the zoom factor of a perspective and saves its state.
     */
    @Override
    public void execute() {
        double currentZoom = this.choixPerspective.getZoomFactor();
        double newZoom = currentZoom * scaleFactor;
        choixPerspective.setZoomFactor(newZoom);
        caretaker.saveState(this.choixPerspective.saveToMemento(), choixPerspective.isFlag());
    }
}
