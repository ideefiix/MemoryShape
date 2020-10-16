package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;

import java.util.List;

interface ICardDisplay {

    void loadCardsToDisplay(List<Card> cards);
    void cardSelected(Card card);
    boolean isCorrectCardSelected();
    //get iterator







}
