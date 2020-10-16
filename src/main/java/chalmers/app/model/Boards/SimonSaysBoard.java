package chalmers.app.model.Boards;

import chalmers.app.model.Boards.AbstractBoard;

public class SimonSaysBoard extends AbstractBoard {

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public SimonSaysBoard(int level) {
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

    }
}
