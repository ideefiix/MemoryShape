package chalmers.app.model.CardDisplays;


import chalmers.app.model.Card;

import java.util.Collections;
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
            nextDisplay();
        } else {
            correctCardSelected = false;
        }
        /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true

         */
    }

    private void nextDisplay(){
        nextDisplayCards.clear();
        if(cardsToDisplay.size() != 0) {
            nextDisplayCards.add(cardsToDisplay.get(0));    //Kan orsaka bug om cardsToDisplay är tom
            cardsToDisplay.remove(0);
            expectedCard = nextDisplayCards.get(0);
        }
    }

    @Override
    public void setUp(List<Card> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }

    public List<Card> getCardList(){
        return cardsToDisplay;
    }



}
