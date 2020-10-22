package chalmers.app.model;

/**
 * A modified observer interface.
 * Used by the Game class to achieve a weaker dependency
 * of the BoardController class.
 */
public interface GameObserver {

    void update(ICardIterator diplayIterator, ICardIterator boardIterator);
    void update(String message);


}
