package chalmers.app.model;



import chalmers.app.model.Boards.FrenzyBoard;
import chalmers.app.model.Boards.IBoard;
import chalmers.app.model.Boards.SimonSaysBoard;
import chalmers.app.model.Boards.StandardBoard;
import chalmers.app.model.CardDisplays.*;

import java.util.List;

/**
 * A facade class used by the mainController class.
 * This class communicates with- and brings together
 * the many classes in the model.
 */

public class Game {

    /**
     * Enum used when creating a game
     */
    public enum GameMode{
        STANDARD, SIMONSAYS, FRENZY;
    }

    private GameObserver observer;
    private IBoard board2;
    private ICardDisplay cardDisplay2;
    private Player player;
    private int level = 0;
    private GameMode mode;
    private boolean newLevel;

    /**
     * Constructor that takes in the enum GameMode to
     * create a game of one of the three existing modes.
     */
    public Game(String playerName, GameMode mode) {
        this.player = new Player(playerName,3);
        this.mode = mode;
        switch (mode){
            case STANDARD:
                board2 = new StandardBoard(level);
                cardDisplay2 = new StandardCardDisplay();
                break;

            case FRENZY:
                board2 = new FrenzyBoard(level);
                cardDisplay2 = new FrenzyCardDisplay();
                break;

            case SIMONSAYS:
                board2 = new SimonSaysBoard(level);          //BORDE VARA SIMONSAYSMODE
                cardDisplay2 = new SimonSaysCardDisplay();   //HÄR OCKSÅ
                break;

        }
        initNewLevel();
    }


    /**
     * Sets up the observer (in this case boardController)
     * for the first level of the game.
     */
    public void setUpObserver(){ //kan nog göras i konstruktorn senare.
        observer.update(cardDisplay2.createIterator(), board2.createIterator());
        observer.update("new_level");
    }


    /**
     * Takes in the selected card and updates the conditions
     * in the board as well as the cardDisplay depending on
     * if the card was correct.
     * Also sends an updated version of the board and cardDisplay
     * to the observer (BoardController class).
     */
    public void onClick(ICard selectedCard){
        newLevel = false;
        board2.flipIncorrectCards();
        cardDisplay2.cardSelected(selectedCard);
        if(cardDisplay2.isCorrectCardSelected()){
            correctCardSelected(selectedCard);
        } else {
            inCorrectCardSelected(selectedCard);
        }
        observer.update(cardDisplay2.createIterator(), board2.createIterator());
        if(newLevel){observer.update("new_level");}
        newLevel = false;
    }

    /**
     * Sub method to onClick().
     * updates the conditions based on that the card was correct
     */
    private void correctCardSelected(ICard selectedCard){
        player.incScore();
        board2.correctCard(selectedCard);
        if(board2.isLevelComplete()){
            if(isGameComplete()){
                gameComplete();
            }
            initNewLevel();
            newLevel = true;
        }
    }
    /**
     * Sub method to onClick().
     * updates the conditions based on that the card was incorrect
     */
    private void inCorrectCardSelected(ICard selectedCard){
        board2.incorrectCard(selectedCard);
        player.decLife();
        observer.update("decrement_life");
        if(!player.IsAlive()){
            gameOver();
        }
    }

    /**
     * initializes a new level. Also increases the level so that
     *
     */
    public void initNewLevel(){
        level++;
        board2.generateBoard(level);
        cardDisplay2.setUp(board2.getActiveCardList()); //frenzydisplay ska bara ha en av varje card som används i activecardslist
    }

    public boolean isGameComplete(){
        if(mode == GameMode.FRENZY){
            return level >= 25;
        }
        else{
            return level >= 22;
        }
    }



    public void gameComplete(){
        observer.update("game_complete");
    }

    public void gameOver(){
        observer.update("game_over");
    }

    public void setGameObserver(GameObserver observer){
        this.observer = observer;
    }



    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentScore() {
        return player.getCurrentScore();
    }

    public String getName() {
        return player.getName();
    }

    public ICardDisplay getCardDisplay() {
        return cardDisplay2;
    }
}
