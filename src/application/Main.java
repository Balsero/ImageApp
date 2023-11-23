/**
 * The Main class is the entry point of the application and initializes the model, view, controller,
 * and serialization objects, and deserializes objects from a file.
 */
package application;

import java.io.IOException;
import java.util.List;
import controller.Controller;
import controller.Serialization;
import memento.Caretaker;
import modele.Image;
import modele.OtherPerspective;
import modele.Perspective;
import view.UserView;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Image modelImage = new Image();
        Perspective modelPerspective = new Perspective();
        OtherPerspective modelOtherPerspective = new OtherPerspective();
        UserView view = new UserView(modelImage, modelPerspective, modelOtherPerspective);
        Controller controller = new Controller(modelImage, modelPerspective, modelOtherPerspective, view);
        controller.readFile();
        controller.displayView();

    }
}
