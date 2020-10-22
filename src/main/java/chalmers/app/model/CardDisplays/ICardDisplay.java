package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.ICard;
import chalmers.app.model.IterableCards;

import java.util.List;

public interface ICardDisplay extends IterableCards {


    void cardSelected(ICard card);
    boolean isCorrectCardSelected();
    void setUp(List<ICard> cardsToDisplay);



}
