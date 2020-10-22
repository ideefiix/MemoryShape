/**
 * Authors: Kevin
 * Responsibility: Represents and holds the code for the card display of cards used in the Standard mode of the game
 * Used by: Game
 * Uses: ICard
 */
package chalmers.app.model.CardDisplays;

import chalmers.app.model.ICard;
import java.util.List;


public class StandardCardDisplay extends AbstractCardDisplay {

    @Override
    public void setUp(List<ICard> cards) {
        loadCardsToDisplay(cards);
        nextDisplayCards.add(cardsToDisplay.get(0));
        cardsToDisplay.remove(0);
        expectedCard = nextDisplayCards.get(0);
    }

}
