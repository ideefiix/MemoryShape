package chalmers.app.model.CardDisplays;


import chalmers.app.model.Card;
import chalmers.app.model.ICard;

import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp Cards
 */
public class StandardCardDisplay extends AbstractCardDisplay {


    @Override
    public void cardSelected(ICard selectedCard) {
        if(selectedCard.equals(expectedCard)){
            correctCardSelected = true;
            nextDisplay();
        } else {
            correctCardSelected = false;
        }
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
    public void setUp(List<ICard> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }

    public List<ICard> getCardList(){
        return cardsToDisplay;
    }



}
