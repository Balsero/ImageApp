/**
 * The Memento class represents a snapshot of the state of an object, including an image icon,
 * position, and zoom factor.
 */
package memento;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Memento {

    private final ImageIcon imageIcon;
    private final Point position;
    private final double zoomFactor;

    // The code you provided is a constructor for the Memento class. It takes three
    // parameters: an
    // ImageIcon object, a Point object, and a double value.
    public Memento(ImageIcon imageIcon, Point position, double zoomFactor) {
        this.imageIcon = imageIcon;
        this.position = position;
        this.zoomFactor = zoomFactor;
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
     * The function returns the position of a Point object.
     * 
     * @return The method is returning a Point object.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * The function returns the zoom factor as a double.
     * 
     * @return The method is returning the value of the variable "zoomFactor".
     */
    public double getZoomFactor() {
        return zoomFactor;
    }

}