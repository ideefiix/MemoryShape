package chalmers.app.model;

public class SimonSaysBoard extends AbstractBoard {

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public SimonSaysBoard(int level) {
        createShapeList();
        generateBoard(level);
    }

    @Override
    public void generateBoard(int currentLevel) {

    }
}
