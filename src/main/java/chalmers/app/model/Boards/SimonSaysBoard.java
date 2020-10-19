package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;

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
         nActiveCards = 3 + currentLevel;
        Collections.shuffle(allCardsList);
         activeCardList = new ArrayList<>();
         for( int i = 0; i< nActiveCards;i++){
             Card c = allCardsList.get(i);
             activeCardList.add(c);
         }
        Collections.shuffle(activeCardList);
    }
}
