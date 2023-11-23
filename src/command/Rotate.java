package command;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import memento.Caretaker;
import modele.IPerspective;

/**
 * The `Rotate` class is a Java class that implements the `Command` interface
 * and provides methods to
 * rotate an image by a specified number of degrees.
 */
public class Rotate implements Command {

    private IPerspective choixPerspective;
    private double degrees;
    private Caretaker caretaker = Caretaker.getInstance();;

    // The `public Rotate(IPerspective choixPerspective, double degrees)` is a
    // constructor for the
    // `Rotate` class. It takes two parameters: `choixPerspective` of type
    // `IPerspective` and `degrees`
    // of type `double`.
    public Rotate(IPerspective choixPerspective, double degrees) {
        this.choixPerspective = choixPerspective;
        this.degrees = degrees;
        // caretaker.saveState(choixPerspective.saveToMemento(),
        // choixPerspective.isFlag());
    }

    /**
     * The execute function rotates an image by a specified number of degrees and
     * updates the image
     * icon.
     */
    @Override
    public void execute() {

        BufferedImage image = choixPerspective.convertToBufferedImage(choixPerspective.getImageIcon());
        image = rotateImage(image, degrees);
        choixPerspective.setImageIcon(new ImageIcon(image));

    }

    /**
     * The `rotateImage` function takes an original image and a rotation angle in
     * degrees, and returns
     * a new BufferedImage object that is the original image rotated by the
     * specified angle.
     * 
     * @param originalImage The originalImage parameter is a BufferedImage object
     *                      that represents the
     *                      image that you want to rotate.
     * @param degrees       The degrees parameter represents the angle by which the
     *                      image should be rotated.
     *                      It is a double value that specifies the rotation angle
     *                      in degrees.
     * @return The method returns a BufferedImage object, which represents the
     *         rotated image.
     */
    public BufferedImage rotateImage(BufferedImage originalImage, double degrees) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // These lines of code are creating a new BufferedImage object called
        // `rotatedImage` with the
        // same width, height, and image type as the original image. Then, it retrieves
        // the Graphics2D
        // object from the `rotatedImage` using the `getGraphics()` method. The
        // `Graphics2D` object is
        // used to perform the rotation operation on the image.
        BufferedImage rotatedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D graphics = (Graphics2D) rotatedImage.getGraphics();

        // The line `AffineTransform at =
        // AffineTransform.getRotateInstance(Math.toRadians(degrees),
        // width / 2, height / 2);` is creating an AffineTransform object that
        // represents a rotation
        // transformation.
        AffineTransform at = AffineTransform.getRotateInstance(
                Math.toRadians(degrees), width / 2, height / 2);

        graphics.setTransform(at);
        graphics.drawImage(originalImage, 0, 0, null);
        graphics.dispose();

        return rotatedImage;
    }

}
