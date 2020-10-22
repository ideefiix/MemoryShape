package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.CardIterator;
import chalmers.app.model.ICardIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to hold common code between the different CardDisplay classes
 */

public abstract class AbstractCardDisplay implements ICardDisplay {

    protected List<Card> cardsToDisplay = new ArrayList<>();
    protected List<Card> nextDisplayCards = new ArrayList<>();;
    protected Card expectedCard;
    protected boolean correctCardSelected;





    /**
     * Loads the CardDisplay with cards to display
     * @param cards: List containing the cards to be displayed.
     */

    @Override
    public void loadCardsToDisplay(List<Card> cards){
        for(Card card: cards){
            cardsToDisplay.add(new Card(card.getColor(),card.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
    }

    @Override
    public ICardIterator createIterator() {
        return new CardIterator(nextDisplayCards);
    }


    /**
     * Takes in the card selected by the player and updates the conditions within the CardDisplay
     * @param card: The card selected by the player
     */
    @Override
    public abstract void cardSelected(Card card);

    @Override
    public abstract void setUp(List<Card> cards);

    public void setCardsToDisplay(List<Card> cardsToDisplay) {
        this.cardsToDisplay = cardsToDisplay;
    }

    @Override
    public boolean isCorrectCardSelected(){
        return correctCardSelected;
    }

    public void setExpectedCard(Card expectedCard) {
        this.expectedCard = expectedCard;
    }

//public ?abstract? Iterator getIterator();


    public List<Card> getNextDisplayCards() {
        return nextDisplayCards;
    }

    public Card getExpectedCard() {
        return expectedCard;
    }

    //kommer antagligen inte behövar när getIterator() metoden finns.
    public List<Card> getCardsToDisplay() {
        return cardsToDisplay;
    }



}
