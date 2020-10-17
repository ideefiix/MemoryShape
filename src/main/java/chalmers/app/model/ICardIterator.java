package chalmers.app.model;

public interface ICardIterator {

    boolean hasNext();
    void getNext();
    Card getCard();

}
