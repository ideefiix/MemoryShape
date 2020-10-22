package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.IterableCards;

import java.util.List;

public interface ICardDisplay extends IterableCards {

    void loadCardsToDisplay(List<Card> cards);
    void cardSelected(Card card);
    boolean isCorrectCardSelected();
    void setUp(List<Card> cardsToDisplay);
    List<Card> getCardList(); //temporär
    void setExpectedCard(Card expectedCard);

    //get iterator







}
