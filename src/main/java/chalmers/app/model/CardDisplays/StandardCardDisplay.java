package chalmers.app.model.CardDisplays;


import chalmers.app.model.Card;

import java.util.List;

/**
 * Klass för den display som visar upp Cards
 */
public class StandardCardDisplay extends AbstractCardDisplay {

    //Osynliga instansvariabler:
    //cardsToDisplay
    //nextDisplayCards
    //expectedCard
    //correctCardSelected




    @Override
    public void cardSelected(Card selectedCard) {

        if(selectedCard.equals(expectedCard)){
            correctCardSelected = true;
            cardsToDisplay.remove(0);
            nextDisplayCards.clear();
            nextDisplayCards.add(cardsToDisplay.get(0));    //Kan orsaka bug om cardsToDisplay är tom
            expectedCard = nextDisplayCards.get(0);
        } else {
            correctCardSelected = false;
        }
        /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true

         */
    }

    @Override
    public void setUp(List<Card> cardsToDisplay) {
        loadCardsToDisplay(cardsToDisplay);
        nextDisplayCards.add(cardsToDisplay.get(0));
        expectedCard = cardsToDisplay.get(0);
    }



}
