/**
 * Authors: Nils, Filip
 * Responsibility: Holds common code between the different board classes
 * Used by:
 * Uses: ICard, Card, Color, Shape, ICardIterator
 */
package chalmers.app.model.Boards;

import chalmers.app.model.*;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class AbstractBoard implements IBoard {


    List<ICard> allCardsList = new ArrayList<>();
    List<ICard> activeCardList = new ArrayList<>();;
    int nActiveCards = 0;
    boolean levelComplete = false;


    /**
     * Initalizes the list with ALL cards
     */

    public void fillAllCardsList(){
        for(Color color: Color.values()){
            for(Shape shape: Shape.values()){
                ICard card = new Card(color,shape,CardState.FACEDOWN);
                allCardsList.add(card);
            }
        }
        Collections.shuffle(allCardsList);
    }


    /**
     * Sets the CardState of the selected card to CORRECT
     */
    @Override
    public void correctCard(ICard selectedCard) {
        Card mutalbeCard = selectedCard.getMutableCard();
        mutalbeCard.setCorrect();
    }


    /**
     * Sets the CardState of the selected card to INCORRECT
     */
    @Override
    public void incorrectCard(ICard selectedCard) {
        Card mutableCard = selectedCard.getMutableCard();
        mutableCard.setIncorrect();
    }

    /**
     * Restores the incorrect cards to face down by
     * changing the CardState of the cards
     */
    @Override
    public void flipIncorrectCards() {
        for(ICard c: activeCardList){
            if(c.getState().equals(CardState.INCORRECT)){
                Card card = c.getMutableCard();
                card.setFaceDown();
                break;
            }
        }
    }


    /**
     * Returns true if all cards on the board are correct
     * by checking if their CardState is CORRECT
     */
    @Override
    public boolean isLevelComplete(){
        levelComplete = true;
        for(ICard c: activeCardList) {
            if (c.getState() !=  CardState.CORRECT){
                levelComplete = false;
                break;
            }
        }
        return levelComplete;
    }


    /**
     * Generates a board of different cards by filling the activeCardList
     * @param currentLevel
     */
    @Override
    public abstract void generateBoard(int currentLevel);


    /**
     * Returns an iterator of the activeCardList, containing the different cards on the board
     */
    @Override
    public ICardIterator createIterator() {
        return new CardIterator(activeCardList);
    }


    @Override
    public List<ICard> getActiveCardList() {
        return activeCardList;
    }


}
