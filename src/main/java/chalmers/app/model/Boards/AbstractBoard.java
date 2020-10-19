package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractBoard implements IBoard {

    List<Card> allCardsList = new ArrayList<>();
    List<Card> activeCardList;
    int nActiveCards = 0;
    boolean hideCards; //När hide cards = true så ska cardselector synas, annars inte
    boolean levelComplete = false;

    //Methods


    /**
     * Initalizes the list with ALL cards
     */
    @Override
    public void fillAllCardsList(){
        for(Color color: Color.values()){
            for(Shape shape: Shape.values()){
                Card card = new Card(color,shape,CardState.FACEUP);
                allCardsList.add(card);
            }
        }
    }

    @Override
    public void correctCard(Card selectedCard) {
        selectedCard.setState(CardState.CORRECT);
    }

    @Override
    public void incorrectCard(Card selectedCard) {
        selectedCard.setState(CardState.INCORRECT);
    }

    @Override
    public void flipIncorrectCards() {
        for(Card c: activeCardList){
            if(c.getState().equals(CardState.INCORRECT)){
                c.setState(CardState.FACEDOWN);
                break;
            }
        }
    }

    @Override
    public boolean isLevelComplete(){
        levelComplete = true;
        for(Card c: activeCardList) {
            if (c.getState() !=  CardState.CORRECT){
                levelComplete = false;
                break;
            }
        }
        return levelComplete;
    }

    /*
    /**
     * Returns the IDs of the activecards
     * @return

    @Override
    public List<String> getIds(){
        List < String > colorShape = new ArrayList<>();
        for(int i = 0; i < activeCardList.size(); i++){
            String id = activeCardList.get(i).getColor().name() + activeCardList.get(i).getShape().name();
            colorShape.add(id);
        }
        return colorShape;
    }
    */

    /**
     * Create a board
     * @param currentLevel
     */
    @Override
    public abstract void generateBoard(int currentLevel);


    /*@Override
    public void showCards(){
        hideCards = false;
    }

    //@Override
    public void hideCards(){
        hideCards = true;
    }

    //@Override
    public boolean getHideCards(){
        return hideCards;
    }*/

    @Override
    public List<Card> getActiveCardList() {
        return activeCardList;
    }

    @Override
    public int getNumberOfShapes() {
        return nActiveCards;
    }

}
