package chalmers.app.model;


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
    public void correctCard() {
        
    }

    @Override
    public void incorrectCard() {

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