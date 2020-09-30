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
    public void onClick(Card card){ //borde ändras till index
        if(card.getColor() == cardSelector.getSelectedCard().getColor() && card.getShape() == cardSelector.getSelectedCard().getShape()){

            board.removeClickedCard(0); //Ändrat till index. Metoden saknade metodkropp innan också
            cardSelector.changeSelectedShape();
            //TODO Give player score,

        }else{
            player.decLife();
            if(player.IsAlive() == false){
                //TODO game over?
            }
        }
    }


    private void runGame(){    //Ska brytas upp i submetoder
        int guessedIndex = 0; //temporär init
        level = 1; //max 22, ska man ha levelselect i menyn?
        while(level < 23 && player.lives > 0) {
            board.generateBoard(level);
            cardSelector.restartList(board.getActiveCardList());
            board.showCards();
            //Delay
            board.hideCards();
            while (board.getActiveCardList().size() > 0) { //Kommer inte kunna gå efter size sen om "space" finns!
                //input för guessedIndex, just nu gissas alltid den första
                if (board.getActiveCardList().get(guessedIndex).equals(cardSelector.getSelectedCard())) {
                    board.removeClickedCard(guessedIndex);
                    cardSelector.changeSelectedShape();
                    //Displaya att det är rätt?
                } else {
                    player.lives = player.lives - 1;     //private på lives
                    //Displaya att det är fel?
                }
            }
            //Borde ha ge något grattis (bara respons) på att man klarat av en nivå. Ska man få tillbaka ett liv om det förlorats? Kan ha "tomma" hjärtan och olika max HP
            level++;
        }
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
