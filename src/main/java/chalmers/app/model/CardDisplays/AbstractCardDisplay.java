package chalmers.app.model.CardDisplays;

import chalmers.app.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to hold common code between the different CardDisplay classes
 */

public abstract class AbstractCardDisplay implements ICardDisplay {

    protected List<ICard> cardsToDisplay = new ArrayList<>();
    protected List<ICard> nextDisplayCards = new ArrayList<>();;
    protected ICard expectedCard;
    protected boolean correctCardSelected;


    /**
     * Loads the CardDisplay with cards to display
     * @param cards: List containing the cards to be displayed.
     */

    @Override
    public void loadCardsToDisplay(List<ICard> cards){
        for(ICard card: cards){
            cardsToDisplay.add(new Card(card.getColor(),card.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
    }

    /**
     * Returns an iterator containing the cards to be displayed
     */

    @Override
    public ICardIterator createIterator() {
        return new CardIterator(nextDisplayCards);
    }


    /**
     * Takes in the card selected by the player and updates the conditions within the CardDisplay
     * @param card: The card selected by the player
     */
    @Override
    public abstract void cardSelected(ICard card);

    /**
     * Prepares the cardDisplay to take in the first card
     * Also prepares the first card(s) to be displayed
     */

    @Override
    public abstract void setUp(List<ICard> cards);

    public void setCardsToDisplay(List<ICard> cardsToDisplay) {
        this.cardsToDisplay = cardsToDisplay;
    }

    /**
     * Returns true if the last selected card was correct
     */
    @Override
    public boolean isCorrectCardSelected(){
        return correctCardSelected;
    }

    public void setExpectedCard(ICard expectedCard) {
        this.expectedCard = expectedCard;
    }

//public ?abstract? Iterator getIterator();


    public List<ICard> getNextDisplayCards() {
        return nextDisplayCards;
    }

    public ICard getExpectedCard() {
        return expectedCard;
    }

    //kommer antagligen inte behövar när getIterator() metoden finns.
    public List<ICard> getCardsToDisplay() {
        return cardsToDisplay;
    }



}
