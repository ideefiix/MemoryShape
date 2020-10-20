package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;

import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp sekvensen av Cards i Simon Says game modet
 */
public class SimonSaysCardDisplay extends AbstractCardDisplay {

    //Osynliga instansvariabler:
    //cardsToDisplay
    //nextDisplayCards
    //expectedCard
    //correctCardSelected

    /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true
        i simon says behöver inte nextDisplayCards updateras förrän leveln är avklarad.


         */


    @Override

    public void cardSelected(Card selectedCard) {
        if (selectedCard.equals(expectedCard)) {
            correctCardSelected = true;
            if(cardsToDisplay.size() > 0) {
                expectedCard = cardsToDisplay.get(0);
                nextDisplayCards.clear();
                cardsToDisplay.remove(0);
            }
            nextDisplayCards.add(selectedCard);

        } else {
            correctCardSelected = false;
        }
    }



    @Override
    public void setUp (List<Card> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.addAll(cardsToDisplay);
        expectedCard = cardsToDisplay.get(0);
        cardsToDisplay.remove(0);
        }




    @Override
    public List<Card> getCardList() {
        return null;
    }


}