package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import chalmers.app.model.ICard;
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrenzyCardDisplay extends AbstractCardDisplay {


    @Override
    public void cardSelected(ICard selectedCard) {

        if(selectedCard.equals(expectedCard)){
            correctCardSelected = true;
            nextDisplay();
        } else {
            correctCardSelected = false;
        }
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
    public void setUp(List<ICard> cards) {
        loadCardsToDisplay(cards);
        sortCardsToDisplay();
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }

    public void sortCardsToDisplay(){
        List<ICard> tempList = new ArrayList<>();
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

    public List<ICard> getCardList(){
        return cardsToDisplay;
    }



}
