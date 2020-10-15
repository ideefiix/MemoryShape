package chalmers.app.model;

import java.util.List;

interface ICardDisplay {

    void loadCardsToDisplay(List<Card> cards);
    void cardSelected(Card card);
    boolean isCorrectCardSelected();
    //get iterator







}
