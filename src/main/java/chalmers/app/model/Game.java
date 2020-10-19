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

    private boolean boardCleared = false;
    private Player player;
    private int level = 0;
    private GameMode mode;


    public Game(Player player, GameMode mode) {
        this.player = player;
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
        initNewLevel();
    }

    public void setUpObserver(){ //kan nog göras i konstruktorn senare.
        observer.update(cardDisplay2.createIterator(), board2.createIterator());
    }



    /**
     * Call with a card from the board!
     */



    public void onClick(Card selectedCard){
        boolean newlevel = false;
        board2.flipIncorrectCards();
        cardDisplay2.cardSelected(selectedCard);
        if(cardDisplay2.isCorrectCardSelected()){
            board2.correctCard(selectedCard);
            if(board2.isLevelComplete()){
                if(isGameComplete()){
                    gameComplete();
                }
                initNewLevel();
                newlevel = true;
            }
        } else {
            board2.incorrectCard(selectedCard);
            player.decLife();
            if(!player.IsAlive()){
                gameOver();
            }
        }
        observer.update(cardDisplay2.createIterator(), board2.createIterator());
        if(newlevel){observer.update("newLevel");}

    }

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






    public void incLevel(){
        level++;
    }

    private void hideCards(){}

    private void hideCardSelector(){}//kanske toggles istället



    public IBoard getBoard(){
        return board2;
    }

    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }


    public ICardDisplay getCardDisplay(){return cardDisplay2;}



    public boolean getBoardCleared() {
        return boardCleared;
    }


    public void setBoardCleared(boolean b) {
        boardCleared = b;
    }



}
