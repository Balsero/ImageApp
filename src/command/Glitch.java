/**
 * The Glitch class is a Java command that applies a glitch effect to an image.
 */
package command;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import memento.Caretaker;
import modele.IPerspective;

public class Glitch implements Command {

    private IPerspective choixPerspective;
    private Caretaker caretaker = Caretaker.getInstance();

    // The code snippet is defining a constructor for the `Glitch` class that takes an `IPerspective`
    // object as a parameter. The `IPerspective` object is then assigned to the `choixPerspective`
    // instance variable of the `Glitch` class.
    public Glitch(IPerspective choixPerspective) {
        this.choixPerspective = choixPerspective;
    }

    @Override
    public void execute() {

        BufferedImage image = choixPerspective.convertToBufferedImage(choixPerspective.getImageIcon());
        appliquerEffetGlitch(image);
        choixPerspective.setImageIcon(new ImageIcon(image));
        // caretaker.saveState(choixPerspective.saveToMemento(),
        // choixPerspective.isFlag());

    }

    /**
     * The function applies a glitch effect to a given image by randomly duplicating or shifting
     * portions of a randomly chosen line.
     * 
     * @param image The parameter "image" is a BufferedImage object, which represents an image in Java.
     * It contains the pixel data and other information about the image.
     */
    public void appliquerEffetGlitch(BufferedImage image) {
        Random random = new Random();
        int width = image.getWidth();
        int height = image.getHeight();

        // Choisissez une ligne aléatoire pour commencer le "glitch"
        int yStart = random.nextInt(height);

        for (int y = yStart; y < yStart + 20 && y < height; y++) {
            int glitchAmount = random.nextInt(20);

            // Dupliquer ou décaler des portions de la ligne
            for (int x = 0; x < width - glitchAmount; x++) {
                int newX = x + glitchAmount;
                if (newX < width) {
                    Color color = new Color(image.getRGB(newX, y));
                    image.setRGB(x, y, color.getRGB());
                }
            }
        }
    }

}
