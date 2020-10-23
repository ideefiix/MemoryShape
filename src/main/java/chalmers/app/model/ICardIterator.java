/**
 * Authors: Kevin
 * Responsibility: An immutable interface for the CardIterator class
 * Used by: Game, BoardController, IBoard, AbstractBoard, ICardDisplay, AbstractCardDisplay
 * Uses:
 */

package chalmers.app.model;


/**
 * An immutable interface for the CardIterator class
 */
public interface ICardIterator {

    boolean hasNext();

    boolean hasCard();

    void step();

    ICard getCard();

}
