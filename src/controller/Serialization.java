/**
 * The Serialization class provides methods to serialize and deserialize a list of objects.
 */
package controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    // Méthode pour sérialiser un ensemble d'objets variés
    /**
     * The function serializes a list of objects and writes them to a file.
     * 
     * @param objets   The "objets" parameter is a List of Objects that you want to
     *                 serialize and write
     *                 to a file.
     * @param filename The filename parameter is a String that represents the name
     *                 of the file where
     *                 the serialized objects will be stored.
     */
    public void serializeObjects(List<Object> objets, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Object objet : objets) {
                oos.writeObject(objet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The function deserializeObjects reads objects from a file using
     * ObjectInputStream and returns
     * them as a List.
     * 
     * @param filename The filename parameter is a String that represents the name
     *                 of the file from
     *                 which the objects will be deserialized.
     * @return The method is returning a List of Objects.
     */
    public List<Object> deserializeObjects(String filename) {
        List<Object> objets = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    objets.add(ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objets;
    }

}
