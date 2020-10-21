package chalmers.app.model;

import java.util.List;

public class CardIterator implements ICardIterator {

    public CardIterator(List<Card> cards){
        cardList = cards;
    }

    List<Card> cardList;
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
    public Card getCard() {
        return cardList.get(currentIndex);
    }
}
