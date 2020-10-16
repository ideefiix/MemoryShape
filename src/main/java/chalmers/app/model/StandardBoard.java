package chalmers.app.model;


import chalmers.app.model.enums.Color;
import chalmers.app.model.enums.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardBoard extends AbstractBoard {
    /**
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public StandardBoard(int level) {
        createShapeList();
        generateBoard(level);
    }

    @Override
    public void generateBoard(int currentLevel) {
        numberOfActiveShapes = 3 + (currentLevel * 1);

        activeCardList = new ArrayList<>();
        // Only shapes on the board is active
        for (int i = 0; i < numberOfActiveShapes; i++) {
            activeCardList.add(allCardsList.get(i));
        }
        Collections.shuffle(activeCardList);
    }
}