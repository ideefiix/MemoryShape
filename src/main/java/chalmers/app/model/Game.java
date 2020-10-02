package chalmers.app.model;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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



    /**
     * Runs the main gameplay-loop of the game
     */
    public void runGame() throws InterruptedException, IOException {    //Ska brytas upp i submetoder
        int guessedIndex; //temporär init
        level = 1; //max 22, ska man ha levelselect i menyn?
        while(level < 23 && player.lives > 0) {
            board.generateBoard(level);
            cardSelector.restartList(board.getActiveCardList());
            board.showCards();
            displayInTerminal();
            TimeUnit.SECONDS.sleep(4 + level);      //Temporär lösning för delay. Ha istället så det byter när man klickar "ready"
            board.hideCards();
            displayInTerminal();
            while (board.getActiveCardList().size() > 0 && player.lives > 0) { //Kommer inte kunna gå efter size sen om "space" finns!
                //input för guessedIndex, just nu gissas alltid den första
                guessedIndex = takeTerminalInput();
                guessCard(guessedIndex);
            }
            //Borde ha ge något grattis (bara respons) på att man klarat av en nivå. Ska man få tillbaka ett liv om det förlorats? Kan ha "tomma" hjärtan och olika max HP
            level++;
        }
        System.out.print("Game over!");
    }

    /**
     * Takes the position of the guessed card and matches it to the cardSelector.
     * If it's a match the card is cleared from the board, otherwise the player loses one health.
     *
     */
    private void guessCard(int index){
        if(index >= board.getActiveCardList().size()){
            index = board.getActiveCardList().size() - 1;
        }

        if (board.getActiveCardList().get(index).equals(cardSelector.getSelectedCard())) {
            board.removeClickedCard(index);

            if(board.getActiveCardList().size() > 0) {  //onödigt?
                cardSelector.changeSelectedShape();
            }


            //Displaya att det är rätt?
            System.out.print("Guessed right");
            displayInTerminal();
        } else {
            player.lives = player.lives - 1;     //private på lives
            System.out.print("Oof");
            //Displaya att det är fel?
        }
    }
    /**
     *  Temporary method to be able to run the game using the terminal
     */
    private int takeTerminalInput() throws IOException {
        System.out.println();
        System.out.println("Enter your guess (position)");
        Scanner myInput = new Scanner( System.in );
            return myInput.nextInt();
        //System.out.println(name);
    }

    /**
     *  Temporary method to be able to run the game using the terminal
     */
    private void displayInTerminal(){
        for( int i = 0; i < 20; i++){ //Clearar terminalen med 20 rader
            System.out.println();
        }
        Card displayCard = cardSelector.getSelectedCard();

        if(board.getHideCards()){
            System.out.println("Lives: " + player.lives);
            System.out.println("Display:" + displayCard.getColor() + displayCard.getShape());
            System.out.print("Board:  ");
            for(int i = 0; i < board.getActiveCardList().size(); i++){
                System.out.print("---" + "   ");
            }
        } else {
            System.out.println("Lives: " + player.lives);
            System.out.println("Display: ---");
            System.out.print("Board:  ");
            for (Card c : board.getActiveCardList()) {
                System.out.print("" + c.getColor() + c.getShape() + "   ");
            }
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
