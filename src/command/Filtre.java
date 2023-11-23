/**
 * The Filtre class is a command that applies a black and white filter to an image.
 */
package command;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import memento.Caretaker;
import modele.IPerspective;

public class Filtre implements Command {

    private IPerspective choixPerspective;
    private Caretaker caretaker;

    // This code snippet is the constructor of the `Filtre` class. It takes an `IPerspective` object as
    // a parameter and assigns it to the `choixPerspective` instance variable. It also initializes the
    // `caretaker` variable by calling the `getInstance()` method of the `Caretaker` class.
    public Filtre(IPerspective choixPerspective) {
        this.choixPerspective = choixPerspective;
        caretaker = Caretaker.getInstance();
    }

    @Override
    public void execute() {

        BufferedImage image = choixPerspective.convertToBufferedImage(choixPerspective.getImageIcon());
        appliquerFiltreNoirEtBlanc(image);
        choixPerspective.setImageIcon(new ImageIcon(image));
        caretaker.saveState(choixPerspective.saveToMemento(), choixPerspective.isFlag());

    }

    /**
     * The function applies a black and white filter to an image by converting each pixel to its
     * grayscale equivalent.
     * 
     * @param image The image parameter is a BufferedImage object, which represents an image in Java.
     * It contains the pixel data of the image, including the color information for each pixel.
     */
    public void appliquerFiltreNoirEtBlanc(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Parcourir tous les pixels de l'image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int grayLevel = (int) ((red + green + blue) / 3.0);
                Color gray = new Color(grayLevel, grayLevel, grayLevel);
                image.setRGB(x, y, gray.getRGB());
            }
        }
    }

}
