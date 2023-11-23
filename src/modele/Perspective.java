/**
 * The Perspective class represents a perspective in a graphical application, with properties such as
 * image icon, position, zoom factor, and a flag.
 */
package modele;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import memento.Memento;
import observer.Subject;

public class Perspective extends Subject implements IPerspective {

    private static final long serialVersionUID = 1L;

    private ImageIcon imageIcon;
    private Point position;
    private double zoomFactor = 1.0;
    private double degrees = 0;
    private final boolean flag = true;

    // The `public Perspective()` constructor initializes a new instance of the
    // `Perspective` class. It
    // sets the initial position of the perspective to (0, 0) by creating a new
    // `Point` object with
    // coordinates (0, 0) and assigning it to the `position` variable.
    public Perspective() {

        this.position = new Point(0, 0);

    }

    /**
     * The getImageIcon() function returns an ImageIcon object.
     * 
     * @return The method is returning an ImageIcon object.
     */
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
     * memento and notifies all
     * observers.
     * 
     * @param memento The "memento" parameter is an object that represents the state
     *                of an object at a
     *                particular point in time. It is used to restore the object to
     *                that state. In this code snippet,
     *                the "restoreFromMemento" method takes a "memento" object as a
     *                parameter and uses it
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

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
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

    /**
     * The function returns the value of the flag variable.
     * 
     * @return The method isFlag() is returning a boolean value.
     */
    public boolean isFlag() {
        return flag;
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
