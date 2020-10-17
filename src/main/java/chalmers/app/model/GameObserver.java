package chalmers.app.model;

public interface GameObserver {

    void update(ICardIterator diplayIterator, ICardIterator boardIterator);
    void update(String message);


}
