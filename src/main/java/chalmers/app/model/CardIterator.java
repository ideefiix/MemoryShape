package chalmers.app.model;

import java.util.List;


/**
 * A modified iterator class used for lists of Cards.
 * Used by the board classes and the cardDisplay classes
 * to send an iterator to the controller classes.
 */
public class CardIterator implements ICardIterator {

    public CardIterator(List<ICard> cards){
        cardList = cards;
    }

    List<ICard> cardList;
    int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < cardList.size() - 1;
    }

    @Override
    public boolean hasCard() {
        return currentIndex < cardList.size();
    }

    @Override
    public void step() {
        currentIndex++;
    }

    @Override
    public ICard getCard() {
        return cardList.get(currentIndex);
    }
}
