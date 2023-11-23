/**
 * The PerspectivePanel class is a Java class that extends ParentPanel and implements the Observer
 * interface, and it is responsible for displaying a perspective view based on a given Perspective
 * model.
 */
package view;

import java.awt.Graphics;
import java.awt.Point;
import modele.Perspective;
import observer.Observer;
import observer.Subject;

public class PerspectivePanel extends ParentPanel implements Observer {

    private Perspective modelPerspective;

    // The `public PerspectivePanel(Perspective modelPerspective)` constructor is
    // initializing a new
    // instance of the `PerspectivePanel` class. It takes a `Perspective` object as
    // a parameter, which
    // represents the model for the perspective view.
    public PerspectivePanel(Perspective modelPerspective) {
        super();
        this.modelPerspective = modelPerspective;
        update(modelPerspective);
    }

    /**
     * The paintComponent method is responsible for painting the image on the
     * component with the
     * specified position and zoom factor.
     * 
     * @param g The parameter "g" is an instance of the Graphics class, which is
     *          used for drawing on
     *          the component. It provides methods for drawing shapes, images, and
     *          text on the component's
     *          surface. In this code snippet, the paintComponent method is being
     *          overridden to customize the
     *          drawing behavior of the component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Point pos = modelPerspective.getPosition();
        double zoomFactor = modelPerspective.getZoomFactor();

        if (modelPerspective.getImageIcon() != null) {
            // Calculer la nouvelle taille de l'image
            int newWidth = (int) (modelPerspective.getImageIcon().getIconWidth() * zoomFactor);
            int newHeight = (int) (modelPerspective.getImageIcon().getIconHeight() * zoomFactor);

            g.drawImage(modelPerspective.getImageIcon().getImage(), pos.x, pos.y, newWidth, newHeight, this);
            System.out.println(modelPerspective.getPosition().toString());
        }
    }

    /**
     * The update function validates and repaints the subject.
     * 
     * @param s The parameter "s" is of type "Subject".
     */
    public void update(Subject s) {
        validate();
        repaint();
    }
}
