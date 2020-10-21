package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;

import java.util.Collections;
import java.util.List;

/**
 * Class for cardDisplay used in the simon says mode
 */
public class SimonSaysCardDisplay extends AbstractCardDisplay {


    @Override
    public void cardSelected(Card selectedCard) {
        if (selectedCard.equals(expectedCard)) {
            correctCardSelected = true;
            if(cardsToDisplay.size() > 0) {
                expectedCard = cardsToDisplay.get(0);
                cardsToDisplay.remove(0);
                nextDisplayCards.clear();
                nextDisplayCards.add(selectedCard);
            }
        } else {
            correctCardSelected = false;
        }
        nextDisplayCards.clear();
        nextDisplayCards.add(selectedCard);
    }


    @Override
    public void setUp (List<Card> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.clear();
        nextDisplayCards.addAll(cardsToDisplay);
        nextDisplayCards.add(cardsToDisplay.get(cardsToDisplay.size() - 1));
        expectedCard = cardsToDisplay.get(0);
        cardsToDisplay.remove(0);
        }


}