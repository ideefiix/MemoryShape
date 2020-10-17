package chalmers.app.model;

/**
 * An interface for the different strategies to the runGame method
 */

public interface IGameMode {
    void startUp();
    void cardSelected(int index);
    boolean isCorrectCard();
    boolean levelCompleted();
    void nextLevel();



}
