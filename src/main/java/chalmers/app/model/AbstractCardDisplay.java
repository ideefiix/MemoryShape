package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class AbstractCardDisplay implements ICardDisplay {

    protected List<Card> cardsToDisplay;
    protected List<Card> nextDisplayCards;
    protected boolean correctCardSelected;


    protected int DisplaydCardIndex = 0;
    protected Card DisplayedCard;


    /**
     * Constructor
     */


    /**
     * Tar in en lista med Cards som den byter ut den gamla listan mot och sen shufflar
     * @param cards: List containing the cards to be displayed.
     */

    public void loadCardsToDisplay(List<Card> cards){
        for(Card card: cards){
            cardsToDisplay.add(new Card(card.getColor(),card.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
    }

    public abstract void cardSelected(Card card);
    public abstract boolean isCorrectCardSelected();


    public void changeSelectedCard(){
        if(DisplaydCardIndex + 1 < cardsToDisplay.size()){
            DisplaydCardIndex++;
            DisplayedCard = cardsToDisplay.get(DisplaydCardIndex);
        }
        //TODO Change the GUI image of selectedshape
    }

    public Card getDisplayedCard(){
        return DisplayedCard;
    }

    public void setDisplayedCard(Card displayedCard) {
        this.DisplayedCard = displayedCard;
    }

    public List<Card> getCardsToDisplay() {
        return cardsToDisplay;
    }


     void restartList(List<Card> activeCardList){
        cardsToDisplay = new ArrayList<>();

        for(Card card: activeCardList){
            cardsToDisplay.add(new Card(card.getColor(),card.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
        DisplaydCardIndex = 0;
        DisplayedCard = cardsToDisplay.get(DisplaydCardIndex);
    }


}
