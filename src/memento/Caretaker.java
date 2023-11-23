/**
 * The Caretaker class is responsible for managing and storing the Memento objects in two separate
 * lists, allowing for undo and redo operations.
 */
package memento;

import java.util.ArrayList;

public class Caretaker {

    private static Caretaker instance;
    private ArrayList<Memento> mementoListPerspective = new ArrayList<>();
    private int currentIndexPerspective = -1;
    private ArrayList<Memento> mementoListOtherPerspective = new ArrayList<>();
    private int currentIndexOtherPerspective = -1;

    private Caretaker() {
        // Constructeur vide
    }

    /**
     * The getInstance() function returns the singleton instance of the Caretaker
     * class, creating it if
     * it doesn't exist.
     * 
     * @return The instance of the Caretaker class.
     */
    public static synchronized Caretaker getInstance() {
        if (instance == null) {
            instance = new Caretaker();
        }
        return instance;
    }

    /**
     * The `saveState` function saves a given `Memento` object to the appropriate
     * `ArrayList` based on
     * a boolean flag, and updates the current index accordingly.
     * 
     * @param memento The memento parameter is an object that represents the state
     *                of the system at a
     *                particular point in time. It contains all the necessary data
     *                to restore the system to that
     *                state.
     * @param flag    The "flag" parameter is a boolean value that determines which
     *                perspective to save
     *                the state in. If the flag is true, the state will be saved in
     *                the "mementoListPerspective" and
     *                the "currentIndexPerspective" will be updated accordingly. If
     *                the flag is false, the state will
     */
    public void saveState(Memento memento, boolean flag) {
        ArrayList<Memento> mementoList;
        int currentIndex;

        if (flag) {
            mementoList = mementoListPerspective;
            currentIndex = currentIndexPerspective;
        } else {
            mementoList = mementoListOtherPerspective;
            currentIndex = currentIndexOtherPerspective;
        }

        while (mementoList.size() > currentIndex + 1) {
            mementoList.remove(mementoList.size() - 1);
        }
        mementoList.add(memento);

        if (flag) {
            currentIndexPerspective = currentIndex + 1;
        } else {
            currentIndexOtherPerspective = currentIndex + 1;
        }
    }

    /**
     * The function "undo" returns the previous state of an object based on a flag
     * indicating the
     * perspective, and updates the current index accordingly.
     * 
     * @param flag The flag parameter is a boolean value that determines which
     *             perspective to undo the
     *             action from. If flag is true, it indicates that the action should
     *             be undone from the perspective
     *             of mementoListPerspective. If flag is false, it indicates that
     *             the action should be undone from
     *             the perspective of mementoList
     * @return The method is returning a Memento object.
     */
    public Memento undo(boolean flag) {
        ArrayList<Memento> mementoList;
        int currentIndex;

        if (flag) {
            mementoList = mementoListPerspective;
            currentIndex = currentIndexPerspective;
        } else {
            mementoList = mementoListOtherPerspective;
            currentIndex = currentIndexOtherPerspective;
        }

        if (currentIndex > 0) {
            currentIndex--;

            if (flag) {
                currentIndexPerspective = currentIndex;
            } else {
                currentIndexOtherPerspective = currentIndex;
            }
            return mementoList.get(currentIndex);
        }
        return null;
    }

    /**
     * The function "redo" returns the next Memento object in the mementoList based
     * on the flag
     * parameter, and updates the currentIndex accordingly.
     * 
     * @param flag The flag parameter is a boolean value that determines which
     *             perspective to redo the
     *             action in. If flag is true, it indicates the perspective is
     *             "perspective", and if flag is false,
     *             it indicates the perspective is "other perspective".
     * @return The method is returning a Memento object.
     */
    public Memento redo(boolean flag) {
        ArrayList<Memento> mementoList;
        int currentIndex;

        if (flag) {
            mementoList = mementoListPerspective;
            currentIndex = currentIndexPerspective;
        } else {
            mementoList = mementoListOtherPerspective;
            currentIndex = currentIndexOtherPerspective;
        }

        if (currentIndex < mementoList.size() - 1) {
            currentIndex++;

            if (flag) {
                currentIndexPerspective = currentIndex;
            } else {
                currentIndexOtherPerspective = currentIndex;
            }
            return mementoList.get(currentIndex);
        }
        return null;
    }

    /**
     * The function returns an ArrayList of Memento objects representing a
     * perspective of the memento
     * list.
     * 
     * @return An ArrayList of Memento objects.
     */
    public ArrayList<Memento> getMementoListPerspective() {
        return mementoListPerspective;
    }

    /**
     * The function returns an ArrayList of Memento objects from a different
     * perspective.
     * 
     * @return The method is returning an ArrayList of Memento objects.
     */
    public ArrayList<Memento> getMementoListOtherPerspective() {
        return mementoListOtherPerspective;
    }
}
