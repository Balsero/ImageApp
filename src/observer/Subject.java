/**
 * The Subject class is responsible for managing a list of observers and notifying them when a change
 * occurs.
 */
package observer;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * The attach function adds an observer to a list of observers.
     * 
     * @param o The parameter "o" is an object of type Observer.
     */
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * The detach function removes an observer from the list of observers.
     * 
     * @param o The parameter "o" is an object of type Observer.
     */
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * The function notifies all observers of a subject by calling their update
     * method.
     * 
     * @param s The parameter "s" is an instance of the Subject class.
     */
    public void notifyAllObservers(Subject s) {

        for (Observer observer : observers) {
            observer.update(s);
        }
    }
}
