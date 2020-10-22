/**
 * Authors: Kevin
 * Responsibility: Represents and holds the code for the card display of cards used in the Sequence mode of the game
 * Used by: Game
 * Uses: ICard
 */

package chalmers.app.model.CardDisplays;

import chalmers.app.model.ICard;
import java.util.List;

/**
 * Class for cardDisplay used in the simon says mode
 */
public class SimonSaysCardDisplay extends AbstractCardDisplay {


    @Override
    public void cardSelected(ICard selectedCard) {
        if (selectedCard.equals(expectedCard)) {
            correctCardSelected = true;
            if(cardsToDisplay.size() > 0) {
                expectedCard = cardsToDisplay.get(0);
                cardsToDisplay.remove(0);
                nextDisplayCards.clear();
                nextDisplayCards.add(selectedCard);
            }
        } else {
            correctCardSelected = false;
        }
        nextDisplayCards.clear();
        nextDisplayCards.add(selectedCard);
    }




    @Override
    public void setUp (List<ICard> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.clear();
        nextDisplayCards.addAll(cardsToDisplay);
        nextDisplayCards.add(cardsToDisplay.get(cardsToDisplay.size() - 1));
        expectedCard = cardsToDisplay.get(0);
        cardsToDisplay.remove(0);
        }


}