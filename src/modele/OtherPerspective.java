/**
 * The OtherPerspective class represents a perspective in a graphical application and implements the
 * IPerspective interface.
 */
package modele;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import memento.Memento;
import observer.Subject;

public class OtherPerspective extends Subject implements IPerspective {

    private static final long serialVersionUID = 1L;

    private ImageIcon imageIcon;
    private Point position;
    private double zoomFactor = 1.0;
    private double degrees = 90;
    private final boolean flag = false;

    // The `public OtherPerspective()` constructor initializes the `position`
    // variable of the
    // `OtherPerspective` class with a new `Point` object at coordinates (0, 0).
    // This means that when
    // an instance of the `OtherPerspective` class is created, its initial position
    // will be at the
    // top-left corner of the graphical application.
    public OtherPerspective() {
        this.position = new Point(0, 0);

    }

    /**
     * The function returns an ImageIcon object.
     * 
     * @return The method is returning an ImageIcon object.
     */
    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;

    }

    /**
     * The function sets the image icon and notifies all observers.
     * 
     * @param imageIcon The imageIcon parameter is an instance of the ImageIcon
     *                  class, which represents
     *                  an image icon that can be displayed in a graphical user
     *                  interface.
     */
    @Override
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        notifyAllObservers(this);
    }

    /**
     * The function saves the current state of an object by creating a new Memento
     * object with the
     * current imageIcon, position, and zoomFactor values.
     * 
     * @return The method is returning a Memento object.
     */
    @Override
    public Memento saveToMemento() {
        return new Memento(imageIcon, position, zoomFactor);
    }

    /**
     * The restoreFromMemento function restores the state of an object from a
     * memento object and
     * notifies all observers.
     * 
     * @param memento The "memento" parameter is an object that represents the state
     *                of an object at a
     *                particular point in time. It is used to restore the object to
     *                that state. In this method, the
     *                "memento" object contains the saved state of the object that
     *                needs to be restored.
     */
    @Override
    public void restoreFromMemento(Memento memento) {
        if (memento != null) {
            this.imageIcon = memento.getImageIcon();
            this.position = memento.getPosition();
            this.zoomFactor = memento.getZoomFactor();
        }
        notifyAllObservers(this);
    }

    /**
     * The function returns the position of an object as a Point.
     * 
     * @return The method is returning a Point object.
     */
    @Override
    public Point getPosition() {
        return position;
    }

    /**
     * The function sets the position of an object and notifies all observers.
     * 
     * @param position The position parameter is of type Point, which represents a
     *                 point in a
     *                 two-dimensional space. It typically consists of x and y
     *                 coordinates.
     */
    @Override
    public void setPosition(Point position) {
        this.position = position;
        notifyAllObservers(this);
    }

    /**
     * The function returns the zoom factor as a double.
     * 
     * @return The method is returning the value of the variable "zoomFactor".
     */
    public double getZoomFactor() {
        return zoomFactor;
    }

    /**
     * The function sets the zoom factor and notifies all observers.
     * 
     * @param zoomFactor The zoom factor is a double value that represents the level
     *                   of zoom applied to
     *                   an object or image. It determines how much the object or
     *                   image is magnified or reduced in size.
     */
    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
        notifyAllObservers(this);
    }

    // The `@Override` annotation indicates that the method `isFlag()` is overriding
    // a method from a
    // superclass or implementing an interface method.
    @Override
    public boolean isFlag() {
        return flag;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    /**
     * The toString() function returns a string representation of the
     * OtherPerspective object,
     * including its imageIcon, position, and zoomFactor.
     * 
     * @return The toString() method is returning a string representation of the
     *         object, which includes
     *         the values of the imageIcon, position, and zoomFactor variables.
     */
    @Override
    public String toString() {
        return "OtherPerspective [imageIcon=" + imageIcon + ", position=" + position + ", zoomFactor=" + zoomFactor
                + "]";
    }

    /**
     * The function converts an ImageIcon to a BufferedImage in Java.
     * 
     * @param icon The "icon" parameter is an ImageIcon object that represents an image.
     * @return The method is returning a BufferedImage object.
     */
    public BufferedImage convertToBufferedImage(ImageIcon icon) {
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }
}
