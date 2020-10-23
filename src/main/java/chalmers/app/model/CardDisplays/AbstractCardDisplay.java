/**
 * Authors: Kevin, Nils, Filip
 * Responsibility: Holds common code between the different cardDisplay classes
 * Used by: Game
 * Uses: ICard, ICardIterator
 */

package chalmers.app.model.CardDisplays;

import chalmers.app.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to hold common code between the different CardDisplay classes
 *
 */

public abstract class AbstractCardDisplay implements ICardDisplay {

    List<ICard> cardsToDisplay = new ArrayList<>();
    List<ICard> nextDisplayCards = new ArrayList<>();;
    ICard expectedCard;
    boolean correctCardSelected;


    /**
     * Loads the CardDisplay with cards to display
     * @param cards: List containing the cards to be displayed.
     */

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
     * Takes in the card selected by the player, updates the conditions within
     * the card display to display the next cards.
     * @param selectedCard: The card selected by the player
     */
    @Override
    public void cardSelected(ICard selectedCard){
        if(selectedCard.equals(expectedCard)){
            correctCardSelected = true;
            nextDisplayCards.clear();
            if(cardsToDisplay.size() != 0) {
                nextDisplayCards.add(cardsToDisplay.get(0));
                cardsToDisplay.remove(0);
                expectedCard = nextDisplayCards.get(0);
            }
        } else {
            correctCardSelected = false;
        }
    }


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


    public List<ICard> getNextDisplayCards() {
        return nextDisplayCards;
    }

    public ICard getExpectedCard() {
        return expectedCard;
    }

    public List<ICard> getCardsToDisplay() {
        return cardsToDisplay;
    }

}
