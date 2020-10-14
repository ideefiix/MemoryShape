package chalmers.app.model;

public class Game {
    private Board board;
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
        /**
         * Flip 1 card
         */
        //TODO fixa observer pattern
        for(Card c: board.getActiveCardList()){
            c.setFlipped(false);
            //Should work because card points to a c in the Cardlist
            if(c == card){
                c.setFlipped(true);
            }
        }
        // Was it a good card?
        didUserFindTheCard(card);
        if(didUserFindTheCard(card)){

        }
    }

    public boolean didUserFindTheCard(Card card){
        Card cc = cardSelector.getSelectedCard();
        /**
         * Now Check the flipped card
         */
        if (card.equals(cc)){
            cardSelector.changeSelectedCard();
            return true;
        } else{
            return false;
        }
    }

    public void boardUpdater(){
        if (BoardIsCleared()){
            incLevel();
            newBoard();
        }
        else{
            // Do nothing
        }
    }

    public boolean BoardIsCleared(){
        if(cardSelector.getPlayerGuessedAllCards()){
            return true;
        }
        else{
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


}
