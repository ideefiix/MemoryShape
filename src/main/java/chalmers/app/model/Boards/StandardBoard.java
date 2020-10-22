/**
 * Authors: Kevin
 * Responsibility: An interface used to achieve a weaker dependency on the board classes
 * Used by: Game
 * Uses: ICard
 */

package chalmers.app.model.Boards;


import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.ICard;

import java.util.ArrayList;
import java.util.Collections;

public class StandardBoard extends AbstractBoard {
    /**
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public StandardBoard(int level) {
        fillAllCardsList();
        generateBoard(level);
    }


    @Override
    public void generateBoard(int currentLevel) {
        nActiveCards = 2 + (currentLevel);
        //Collections.shuffle(allCardsList);
        activeCardList = new ArrayList<>();
        // Only shapes on the board is active
        for (int i = 0; i < nActiveCards; i++) {
            ICard c = allCardsList.get(i);
            activeCardList.add(new Card(c.getColor(),c.getShape(),CardState.FACEDOWN));
        }
        Collections.shuffle(activeCardList);
    }
}