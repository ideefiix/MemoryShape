package chalmers.app.model;



import chalmers.app.model.Boards.FrenzyBoard;
import chalmers.app.model.Boards.IBoard;
import chalmers.app.model.Boards.SimonSaysBoard;
import chalmers.app.model.Boards.StandardBoard;
import chalmers.app.model.CardDisplays.ICardDisplay;
import chalmers.app.model.CardDisplays.SimonSaysCardDisplay;
import chalmers.app.model.CardDisplays.StandardCardDisplay;

import java.util.List;

public class Game {

    public enum GameMode{
        STANDARD, SIMONSAYS, FRENZY;
    }

    private GameObserver observer;
    private IBoard board2;
    private ICardDisplay cardDisplay2;

    private Board board;
    private boolean boardCleared = false;
    private Player player;
    private CardDisplay cardDisplay;
    private int level = 0;
    private GameMode mode;

    public Game(Player player, GameMode mode) {
        this.player = player;
        this.mode = mode;
        //skapa Board beroende på mode
        //skapa Display beroende på mode
        initLevel(level);
    }

    public Game(Player player, int level) {//gammal konstruktor
        this.player = player;
        this.level = level;
        board = new Board(level);
        cardDisplay = new CardDisplay(board.getActiveCardList());
    }

    public Game(Player player, int level, GameMode mode) {
        this.player = player;
        this.level = level;

        this.mode = mode;

        switch (mode){
            case STANDARD:
                board2 = new StandardBoard(level);
                cardDisplay2 = new StandardCardDisplay();
                break;

            case FRENZY:
                board2 = new FrenzyBoard(level);
                cardDisplay2 = new StandardCardDisplay();
                break;

            case SIMONSAYS:
                board2 = new SimonSaysBoard(level);          //BORDE VARA SIMONSAYSMODE
                cardDisplay2 = new SimonSaysCardDisplay();   //HÄR OCKSÅ
                break;

        }
        initLevel(level);
    }

    public void newCardSelector(){
        cardDisplay.restartList(board.getActiveCardList());
        cardDisplay.setPlayerGuessedAllCards(false);
    }

    public void newBoard(){
        board.generateBoard(level);
        newCardSelector();
    }

    /**
     * Call with a card from the board!
     */
    public void onClick(Card card){
        // Was it a good card?
        if (didUserFindTheCard(card)) {
            //Yes
            cardDisplay.changeSelectedCard();
            boardCleared = cardDisplay.getPlayerGuessedAllCards();
            card.setisRemoved(true);
            player.incScore();
        }else{
            //No
            player.decLife();
        }
    }


    public void onClick2(Card selectedCard){
        board2.flipIncorrectCards();
        cardDisplay2.cardSelected(selectedCard);
        if(cardDisplay2.isCorrectCardSelected()){
            board2.correctCard(selectedCard);
            if(board2.isLevelComplete()){
                if(isGameComplete()){
                    gameComplete();
                }
                initLevel(level);
            }
        } else {
            board2.incorrectCard(selectedCard);
            player.decLife();
            if(!player.IsAlive()){
                gameOver();
            }
        }
        observer.update(cardDisplay2.createIterator(), board2.createIterator());
    }

    public void initLevel(int level){
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



    public boolean didUserFindTheCard(Card card){
        Card cc = cardDisplay.getSelectedCard();
        /**
         * Now Check the flipped card
         */
        if (card.equals(cc)){
            return true;
        } else{
            return false;
        }
    }


    public void incLevel(){
        level++;
    }

    private void hideCards(){}

    private void hideCardSelector(){}//kanske toggles istället

    public Board getBoard() {
        return board;
    }

    public IBoard getBoard2(){
        return board2;
    }

    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }

    public CardDisplay getCardDisplay() {
        return cardDisplay;
    }

    public ICardDisplay getCardDisplay2(){return cardDisplay2;}

    public List<Card> getCardsOnTheBoard(){
       return board.getActiveCardList();
    }

    public boolean getBoardCleared() {
        return boardCleared;
    }

    public List< String > getActiveIds(){
       return board.getIds();
    }

    public void setBoardCleared(boolean b) {
        boardCleared = b;
    }

    public List< String  > getCardDisplayIDs(){
        return cardDisplay.getIds();
    }

}
