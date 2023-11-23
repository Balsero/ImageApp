// This code defines an interface called `IPerspective` in the `modele` package.
package modele;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.ImageIcon;
import memento.Memento;

public interface IPerspective extends Serializable {

    public ImageIcon getImageIcon();

    public void setImageIcon(ImageIcon imageIcon);

    public Memento saveToMemento();

    public void restoreFromMemento(Memento memento);

    public double getDegrees();

    public void setDegrees(double degrees);

    public Point getPosition();

    public void setPosition(Point position);

    public double getZoomFactor();

    public void setZoomFactor(double zoomFactor);

    public boolean isFlag();

    public BufferedImage convertToBufferedImage(ImageIcon icon);

}
