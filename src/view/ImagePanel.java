/**
 * The ImagePanel class is a view component that displays an image and updates itself when the image
 * model changes.
 */
package view;

import modele.Image;
import observer.Observer;
import observer.Subject;

public class ImagePanel extends ParentPanel implements Observer {

    // The `public ImagePanel(Image modelImage)` constructor is creating a new
    // instance of the
    // `ImagePanel` class and initializing it with the given `modelImage`.
    public ImagePanel(Image modelImage) {
        super();
        update(modelImage);
    }

    // The `update` method is a method that is called when the observed `Subject`
    // object notifies its
    // observers of a change. In this case, the `Subject` object is expected to be
    // an instance of the
    // `Image` class.
    public void update(Subject s) {

        Image model = (Image) s;
        // The code block inside the if statement is updating the image displayed in the
        // ImagePanel.
        if (model.getImageIcon() != null) {
            setImageIcon(model.getImageIcon());
            System.out.println(model.getImageIcon().getIconWidth());
            this.getImageLabel().revalidate();
            this.getImageLabel().repaint();
        }

    }
}
