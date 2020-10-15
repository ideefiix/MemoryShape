package chalmers.app.model;

import java.util.List;

public class Game {
    private Board board;
    private boolean boardCleared = false;
    private Player player;
    private CardSelector cardSelector;
    private int level;

    public Game(Player player, int level) {
        this.player = player;
        this.level = level;
        board = new Board(level);
        cardSelector = new CardSelector(board.getActiveCardList());
    }

    public void newCardSelector(){
        cardSelector.restartList(board.getActiveCardList());
        cardSelector.setPlayerGuessedAllCards(false);
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
                    cardSelector.changeSelectedCard();
                    boardCleared = cardSelector.getPlayerGuessedAllCards();
                    card.setisRemoved(true);
                    player.incScore();
                }else{
                    //No
                    player.decLife();
                }

    }

    public boolean didUserFindTheCard(Card card){
        Card cc = cardSelector.getSelectedCard();
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

    public CardSelector getCardSelector() {
        return cardSelector;
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
        return cardSelector.getIds();
    }

}
