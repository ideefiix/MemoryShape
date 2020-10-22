package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.ICard;
import chalmers.app.model.IterableCards;

import java.util.List;

public interface ICardDisplay extends IterableCards {

    void loadCardsToDisplay(List<ICard> cards);
    void cardSelected(ICard card);
    boolean isCorrectCardSelected();
    void setUp(List<ICard> cardsToDisplay);
    void setExpectedCard(ICard card);








}
