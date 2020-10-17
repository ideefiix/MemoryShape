package chalmers.app.model;

import java.util.ArrayList;

/**
 * Class used as a strategy in the runGame method
 */

public class SimonSaysMode implements IGameMode {
    //private ArrayList<Card> sequence;
    //private Board board;
    //private ICardDisplay cardDisplay;
    private Card currentCard;
    private int currentCardIndex = 0;
    private Boolean levelCompleted;
    private Boolean gameCompleted;
    private Boolean correctCardSelected = false;


    public SimonSaysMode(/*ArrayList<Card> sequence,Board board, ICardDisplay cardDisplay*/) {
        //this.sequence = sequence;
        //this.board = board;
        //this.cardDisplay = cardDisplay;
    }


    @Override
    public void startUp() {
       // board.fillSimonSays(level);
       // cardDisplay.shuffle(board.getActiveCardList());
       // cardDisplay.displaySequence();
       // currentCard = cardDisplay.getActiveCardList.get(currentCardIndex);


    }

    @Override
    public void cardSelected(int index) {  // ta bort innan jag pushar

    }


    public void cardSelected(int index, Board board) { //Indexet är till det klickade kortet på boardet
        if(compareCards(index, board)){
            correctCardSelected = true;
            if(levelCompleted()){

            }
            currentCardIndex++;
        }
        else{
            correctCardSelected = false;
        }
    }

    @Override
    public boolean isCorrectCard() {
        return correctCardSelected;
    }

    @Override
    public boolean levelCompleted() {

        return false;
    }

    @Override
    public void nextLevel() {

    }


    private boolean compareCards(int index, Board board){
        if(board.getActiveCardList().get(index) == currentCard)
        {


            return true;
        }
        else
            {
            return false;
        }
    }


}
