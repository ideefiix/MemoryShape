package chalmers.app.model.Boards;


import chalmers.app.model.Card;
import chalmers.app.model.enums.CardState;

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
        nActiveCards = 3 + (currentLevel);

        activeCardList = new ArrayList<>();
        // Only shapes on the board is active
        for (int i = 0; i < nActiveCards; i++) {
            activeCardList.add(allCardsList.get(i));
        }
        Collections.shuffle(activeCardList);
    }
}