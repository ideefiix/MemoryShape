/**
 * Authors: Kevin
 * Responsibility: A modified observer interface used by the
 * Game class to achieve a weaker dependency of BoardController
 * Used by: Game, BoardController
 * Uses: ICardIterator
 */

package chalmers.app.model;

/**
 * A modified observer interface.
 * Used by the Game class to achieve a weaker dependency
 * of the BoardController class.
 */
public interface GameObserver {

    void update(ICardIterator displayIterator, ICardIterator boardIterator);

    void update(String message);

}
