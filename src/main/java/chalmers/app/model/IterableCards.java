package chalmers.app.model;

/**
 * An interface used by ICardDisplay and IBoard.
 * Used for classes that creates CardIterators.
 */
public interface IterableCards {
    ICardIterator createIterator();
}
