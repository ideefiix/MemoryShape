package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.ICardIterator;

import java.util.ArrayList;
import java.util.Collections;

public class SimonSaysBoard extends AbstractBoard {

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public SimonSaysBoard(int level) {
        fillAllCardsList();
        generateBoard(level);
    }

    /**
     * A different version of the same method in AbstractBoard
     * The incorrect CardState of the cards are set to FACEUP insted of FACEDOWN
     */
    @Override
    public void flipIncorrectCards() {
        for(Card c: activeCardList){
            if(c.getState().equals(CardState.INCORRECT)){
                c.setState(CardState.FACEUP);
                break;
            }
        }
    }

    @Override
    public void generateBoard(int currentLevel) {
         nActiveCards = 2 + currentLevel;
         Collections.shuffle(allCardsList);
         activeCardList = new ArrayList<>();
         for( int i = 0; i< nActiveCards;i++){
             Card c = allCardsList.get(i);
                c.setState(CardState.FACEUP);
             activeCardList.add(c);
         }
        Collections.shuffle(activeCardList);

    }


}
