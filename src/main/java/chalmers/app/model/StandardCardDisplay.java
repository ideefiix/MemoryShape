package chalmers.app.model;


import java.util.ArrayList;
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

    }

    @Override
    public boolean isCorrectCardSelected() {
        return correctCardSelected;
    }
}
