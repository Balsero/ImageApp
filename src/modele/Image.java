/**
 * The Image class represents an image with an ImageIcon and notifies its observers when the image icon
 * is set.
 */
package modele;

import javax.swing.ImageIcon;
import observer.Subject;

public class Image extends Subject implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private ImageIcon imageIcon;

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

}
