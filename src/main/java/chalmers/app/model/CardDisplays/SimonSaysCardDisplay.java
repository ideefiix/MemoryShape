package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;

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

        int i = 0;
        expectedCard = getCardsToDisplay().get(i);
        if (selectedCard.equals(expectedCard)) {
            correctCardSelected = true;
            getCardsToDisplay().remove(0);
        } else {
            correctCardSelected = false;
        }
    }

        public boolean isSequenceCompleted () {
            if (getCardsToDisplay().isEmpty()) {
                return true;
            }
            return false;
        }


        @Override
        public void setUp (List < Card > cardsToDisplay) {
            loadCardsToDisplay(cardsToDisplay);
            expectedCard = getCardsToDisplay().get(0);
        }

    public List<Card> getCardList(){
        return cardsToDisplay;
    }

}