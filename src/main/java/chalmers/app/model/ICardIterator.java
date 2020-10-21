package chalmers.app.model;

public interface ICardIterator {

    boolean hasNext();
    boolean hasCard();
    void step();
    Card getCard();

}
