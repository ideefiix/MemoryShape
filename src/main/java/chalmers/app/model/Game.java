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
    }

    public void newBoard(){
        board.generateBoard(level);
    }

    /**
     * Call with a card from the board!
     */
    public void onClick(Card card){
        if(card.getColor() == cardSelector.getSelectedCard().getColor() && card.getShape() == cardSelector.getSelectedCard().getShape()){

            board.removeClickedCard(card);
            cardSelector.changeSelectedShape();
            //TODO Give player score,

        }else{
            player.decLife();
            if(player.IsAlive() == false){
                //TODO game over?
            }
        }
    }

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
