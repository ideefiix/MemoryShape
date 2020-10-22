/**
 * Authors: Kevin
 * Responsibility: Represents and holds the code for the card display of cards used in the Frenzy mode of the game
 * Used by: Game
 * Uses: ICard
 */

package chalmers.app.model.CardDisplays;

import chalmers.app.model.ICard;
import java.util.ArrayList;
import java.util.List;

public class FrenzyCardDisplay extends AbstractCardDisplay {




    @Override
    public void setUp(List<ICard> cards) {
        loadCardsToDisplay(cards);
        sortCardsToDisplay();
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }


    /**
     * Sorts the ICards in the cardToDisplay list so that identical
     * cards are placed next to each other.
     */
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

                } else {
                    i++;
                }
            }
        }
        cardsToDisplay = tempList;
    }




}
