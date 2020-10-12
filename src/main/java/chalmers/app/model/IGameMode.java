package chalmers.app.model;

/**
 * An interface for the different strategies to the runGame method
 */

public interface IGameMode {
    public void startUp(); //initsialiserar gamemodet
    public void updateSelector();
    public void updateBoard();
    public void takeInput(); //Tar in input från användaren.



}
