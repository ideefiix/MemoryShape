package chalmers.app.model;

/**
 * Class used as an strategy for the runGame method
 */

public class StandardMode implements IGameMode {


    @Override
    public void startUp() {

    }

    @Override
    public void cardSelected(int index) {

    }

    @Override
    public boolean isCorrectCard() {
        return false;
    }

    @Override
    public boolean levelCompleted() {
        return false;
    }

    @Override
    public void nextLevel() {

    }

}
