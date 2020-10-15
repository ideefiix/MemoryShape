package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to hold common code between the different CardDisplay classes
 */

abstract class AbstractCardDisplay implements ICardDisplay {

    protected List<Card> cardsToDisplay;
    protected List<Card> nextDisplayCards;
    protected Card expectedCard;
    protected boolean correctCardSelected;





    /**
     * Loads the CardDisplay with cards to display
     * @param cards: List containing the cards to be displayed.
     */

    public void loadCardsToDisplay(List<Card> cards){
        for(Card card: cards){
            cardsToDisplay.add(new Card(card.getColor(),card.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
    }

    /**
     * Takes in the card selected by the player and updates the conditions within the CardDisplay
     * @param card: The card selected by the player
     */
    public abstract void cardSelected(Card card);

    public abstract boolean isCorrectCardSelected();

    //public ?abstract? Iterator getIterator();



    //kommer antagligen inte behövar när getIterator() metoden finns.
    public List<Card> getCardsToDisplay() {
        return cardsToDisplay;
    }



}
