/**
 * The OtherPerspectivePanel class is a Java class that extends ParentPanel and implements the Observer
 * interface, and it is responsible for displaying the other perspective of an image.
 */
package view;

import java.awt.Graphics;
import java.awt.Point;
import modele.OtherPerspective;
import observer.Observer;
import observer.Subject;

public class OtherPerspectivePanel extends ParentPanel implements Observer {
    private OtherPerspective otherPerspective;

    // The `public OtherPerspectivePanel(OtherPerspective otherPerspective)`
    // constructor is
    // initializing a new instance of the `OtherPerspectivePanel` class. It takes an
    // `OtherPerspective`
    // object as a parameter and assigns it to the `otherPerspective` instance
    // variable.
    public OtherPerspectivePanel(OtherPerspective otherPerspective) {
        super();
        this.otherPerspective = otherPerspective;
        update(otherPerspective);
    }

    /**
     * The paintComponent method is used to draw an image on a component with a
     * specified position and
     * zoom factor.
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

        Point pos = this.otherPerspective.getPosition();
        double zoomFactor = this.otherPerspective.getZoomFactor();

        if (this.otherPerspective.getImageIcon() != null) {
            // Calculer la nouvelle taille de l'image
            int newWidth = (int) (this.otherPerspective.getImageIcon().getIconWidth() * zoomFactor);
            int newHeight = (int) (this.otherPerspective.getImageIcon().getIconHeight() * zoomFactor);

            g.drawImage(this.otherPerspective.getImageIcon().getImage(), pos.x, pos.y, newWidth, newHeight, this);
            System.out.println(this.otherPerspective.getPosition().toString());
        }
    }

    /**
     * The update function validates and repaints the subject.
     * 
     * @param s The parameter "s" is of type "Subject".
     */
    @Override
    public void update(Subject s) {

        validate();
        repaint();
    }
}
