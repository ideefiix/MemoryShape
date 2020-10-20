package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrenzyCardDisplay extends AbstractCardDisplay {

    //Osynliga instansvariabler:
    //cardsToDisplay
    //nextDisplayCards
    //expectedCard
    //correctCardSelected



    @Override
    public void cardSelected(Card selectedCard) {

        if(selectedCard.equals(expectedCard)){
            correctCardSelected = true;
            nextDisplay();
        } else {
            correctCardSelected = false;
        }
        /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true

         */
    }

    private void nextDisplay(){
        nextDisplayCards.clear();
        if(cardsToDisplay.size() != 0) {
            nextDisplayCards.add(cardsToDisplay.get(0));    //Kan orsaka bug om cardsToDisplay är tom
            cardsToDisplay.remove(0);
            expectedCard = nextDisplayCards.get(0);
        }
    }

    @Override
    public void setUp(List<Card> cards) {
        loadCardsToDisplay(cards);
        sortCardsToDisplay();
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }

    private void sortCardsToDisplay(){
        List<Card> tempList = new ArrayList<>();
        while (cardsToDisplay.size() > 0){
            tempList.add(cardsToDisplay.get(0));
            cardsToDisplay.remove(0);
            int i = 0;
            while(i < cardsToDisplay.size()){
                if(cardsToDisplay.get(i).equals(tempList.get(tempList.size() - 1))){
                    tempList.add(cardsToDisplay.get(i));
                    cardsToDisplay.remove(cardsToDisplay.get(i));
                    i--;
                }
                i++;
            }
        }
        cardsToDisplay = tempList;
    }

    public List<Card> getCardList(){
        return cardsToDisplay;
    }



}
