/**
 * Authors: Kevin, Nils, Filip, Edenia
 * Responsibility: A facade class that communicates with- and brings together the classes in the model
 * Used by: MainController
 * Uses: ICard, IBoard, ICardDisplay, IGameObserver
 */

package chalmers.app.model;



import chalmers.app.model.Boards.FrenzyBoard;
import chalmers.app.model.Boards.IBoard;
import chalmers.app.model.Boards.SequenceBoard;
import chalmers.app.model.Boards.StandardBoard;
import chalmers.app.model.CardDisplays.*;



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
        STANDARD, SEQUENCE, FRENZY;
    }

    private GameObserver observer;
    private IBoard board;
    private ICardDisplay cardDisplay;
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
                board = new StandardBoard(level);
                cardDisplay = new StandardCardDisplay();
                break;

            case FRENZY:
                board = new FrenzyBoard(level);
                cardDisplay = new FrenzyCardDisplay();
                break;

            case SEQUENCE:
                board = new SequenceBoard(level);
                cardDisplay = new SequenceCardDisplay();
                break;

        }
        initNewLevel();
    }


    /**
     * Sets up the observer (in this case boardController)
     * for the first level of the game.
     */
    public void setUpObserver(){
        observer.update(cardDisplay.createIterator(), board.createIterator());
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
        board.flipIncorrectCards();
        cardDisplay.cardSelected(selectedCard);
        if(cardDisplay.isCorrectCardSelected()){
            correctCardSelected(selectedCard);
        } else {
            incorrectCardSelected(selectedCard);
        }
        observer.update(cardDisplay.createIterator(), board.createIterator());
        if(newLevel){observer.update("new_level");}
        newLevel = false;
    }

    /**
     * Sub method to onClick().
     * updates the conditions based on that the card was correct
     */
    private void correctCardSelected(ICard selectedCard){
        player.incScore();
        board.correctCard(selectedCard);
        if(board.isLevelComplete()){
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
    private void incorrectCardSelected(ICard selectedCard){
        board.incorrectCard(selectedCard);
        player.decLife();
        observer.update("decrement_life");
        if(!player.isAlive()){
            gameOver();
        }
    }

    /**
     * initializes a new level. Also increases the level so that
     *
     */
    public void initNewLevel(){
        level++;
        board.generateBoard(level);
        cardDisplay.setUp(board.getActiveCardList()); //frenzydisplay ska bara ha en av varje card som används i activecardslist
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
}
