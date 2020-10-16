package chalmers.app.model;

public interface CardIterator {

    boolean hasNext();
    void getNext();
    Card getCard();

}
