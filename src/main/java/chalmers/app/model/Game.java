package chalmers.app.model;



import chalmers.app.model.Boards.IBoard;
import chalmers.app.model.CardDisplays.ICardDisplay;

import java.util.List;

public class Game {

    private IBoard board2;
    private ICardDisplay cardDisplay2;

    private Board board;
    private boolean boardCleared = false;
    private Player player;
    private CardDisplay cardDisplay;
    private int level;

    public Game(Player player, int level) {
        this.player = player;
        this.level = level;
        board = new Board(level);
        cardDisplay = new CardDisplay(board.getActiveCardList());
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

    public void initGame(){

    }

    public void onClick2(Card selectedCard){
        cardDisplay2.cardSelected(selectedCard);
        if(cardDisplay2.isCorrectCardSelected()){
            board2.correctCard(selectedCard);
            if(board2.isLevelComplete()){
                if(isGameComplete()){
                    gameComplete();
                }
                nextLevel(level);
            }
        } else {
            board2.incorrectCard(selectedCard);
            player.lives = player.lives - 1; //Skapa decLife funktion. Gör lives private
            if(!player.IsAlive()){
                gameOver();
            }
        }
        board2.flipIncorrectCards();
        //observer.update()
    }

    public void nextLevel(int level){
        level++;
    }

    public boolean isGameComplete(){
        return false;
    }

    public void gameComplete(){

    }

    public void gameOver(){

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

    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }

    public CardDisplay getCardDisplay() {
        return cardDisplay;
    }

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
