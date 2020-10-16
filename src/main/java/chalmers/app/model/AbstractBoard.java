package chalmers.app.model;

import chalmers.app.model.enums.Color;
import chalmers.app.model.enums.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class AbstractBoard implements IBoard {

    List<Card> allCardsList = new ArrayList<>();
    List<Card> activeCardList;
    int numberOfActiveShapes = 0;
    boolean hideCards; //När hide cards = true så ska cardselector synas, annars inte
    boolean levelComplete = false;

    //Methods


    /**
     * Initalizes the list with ALL cards
     */
    //@Override
    public void fillAllCardsList(){
        for(Color color: Color.values()){
            for(Shape shape: Shape.values()){
                Card card = new Card(color,shape);
                allCardsList.add(card);
            }
        }
    }

    public abstract void correctCard();

    public abstract void incorrectCard();

    public boolean isLevelComplete(){
        return levelComplete;
    }

    /**
     * Returns the IDs of the activecards
     * @return
     */
    //@Override
    public List<String> getIds(){
        List < String > colorShape = new ArrayList<>();
        for(int i = 0; i < activeCardList.size(); i++){
            String id = activeCardList.get(i).getColor().name() + activeCardList.get(i).getShape().name();
            colorShape.add(id);
        }
        return colorShape;
    }

    /**
     * Create a board
     * @param currentLevel
     */
    //@Override
    public abstract void generateBoard(int currentLevel);

    //@Override
    public void removeClickedCard(int index){ //kommer behövas ändras så att kortet ersätts med ett "space" (space och kort borde ha samma interface!)
        activeCardList.remove(index);
    }

    //@Override
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
    }

    //@Override
    public List<Card> getActiveCardList() {
        return activeCardList;
    }

    //@Override
    public List<Card> getAllCardsList() {
        return allCardsList;
    }

    //@Override
    public int getNumberOfShapes() {
        return numberOfActiveShapes;
    }

}
