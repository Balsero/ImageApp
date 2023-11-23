package view;

import javax.swing.*;
import java.awt.*;

/**
 * The ParentPanel class is a JPanel that contains a JLabel for displaying an
 * image, and it provides
 * methods for setting and getting the image icon.
 */
public class ParentPanel extends JPanel {
    private transient JLabel imageLabel;

    // The `public ParentPanel()` constructor is initializing a `ParentPanel`
    // object.
    public ParentPanel() {

        setLayout(new BorderLayout());
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Centre l'image
        imageLabel.setVerticalAlignment(JLabel.CENTER); // Centre l'image verticalement
        add(imageLabel, BorderLayout.CENTER);
        initLabel();

    }

    /**
     * The function initializes a JLabel and sets its alignment to center.
     */
    private void initLabel() {
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

    }

    /**
     * The function returns a JLabel object.
     * 
     * @return The method is returning a JLabel object.
     */
    public JLabel getImageLabel() {
        return imageLabel;
    }

    /**
     * The function sets the image icon of a label.
     * 
     * @param imageIcon The imageIcon parameter is an instance of the ImageIcon
     *                  class, which represents
     *                  an image icon that can be displayed in a graphical user
     *                  interface.
     */
    public void setImageIcon(ImageIcon imageIcon) {
        imageLabel.setIcon(imageIcon);

    }

    // Méthode appelée automatiquement lorsque le panel est redimensionné
    /**
     * This function resizes the image icon of the imageLabel when the panel is
     * resized.
     */
    @Override
    public void doLayout() {
        super.doLayout();

        if (imageLabel.getIcon() != null) {
            setImageIcon((ImageIcon) imageLabel.getIcon());
            this.getImageLabel().revalidate();
            this.getImageLabel().repaint();
        }
    }

    /**
     * The function sets the imageLabel variable to the provided JLabel.
     * 
     * @param imageLabel The imageLabel parameter is a JLabel object that represents
     *                   a label used to
     *                   display an image.
     */
    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }
}
