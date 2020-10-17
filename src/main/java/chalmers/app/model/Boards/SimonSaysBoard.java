package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.ICardIterator;

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

    }


}
