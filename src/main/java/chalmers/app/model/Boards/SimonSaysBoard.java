/**
 * Authors: Kevin
 * Responsibility: Represents and holds the code for the board of cards used in the Sequence mode of the game
 * Used by: Game
 * Uses: ICard
 */
package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.ICard;
import java.util.ArrayList;
import java.util.Collections;

public class SimonSaysBoard extends AbstractBoard {

    /**
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
        for(ICard c: activeCardList){
            if(c.getState().equals(CardState.INCORRECT)){
                Card mutableCard = c.getMutableCard();
                mutableCard.setFaceUp();
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
             ICard c = allCardsList.get(i);
                c = new Card(c.getColor(),c.getShape(),CardState.FACEUP);
             activeCardList.add(c);
         }
        Collections.shuffle(activeCardList);

    }


}
