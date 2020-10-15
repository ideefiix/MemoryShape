package chalmers.app.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp Cards
 */
public class StandardCardDisplay extends AbstractCardDisplay {


    public StandardCardDisplay(List<Card> cardsToDisplay) {
        restartList(cardsToDisplay);
    }

    @Override
    public void cardSelected(Card card) {

    }

    @Override
    public boolean isCorrectCardSelected() {
        return false;
    }
}
