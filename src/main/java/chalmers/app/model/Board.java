package chalmers.app.model;


import chalmers.app.model.enums.Color;
import chalmers.app.model.enums.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
   private List<Card> cardList = new ArrayList<>();
   private List<Card> activeCardList;
   private int numberOfActiveShapes;
   private Color[] allColors = Color.values();
   private Shape[] allShapes = Shape.values();
   private boolean hideCards; //När hide cards = true så ska cardselector synas, annars inte

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public Board(int level) {
        createShapeList();
        generateBoard(level);
    }

    //Methods


    /**
     * Initalizes the list with ALL cards
     */

    public void createShapeList(){
        for(Color color: allColors){
            for(Shape shape: allShapes){
                Card card = new Card(color,shape);
                cardList.add(card);
            }
        }
    }

    /**
     * Returns the IDs of the activecards
     * @return
     */
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
     * @param currentlevel
     */

    public void generateBoard(int currentlevel){
        numberOfActiveShapes = 3 + (currentlevel * 1);
        Collections.shuffle(cardList);

        activeCardList = new ArrayList<>();
        // Only shapes on the board is active
        for (int i = 0; i < numberOfActiveShapes; i++){
            activeCardList.add(cardList.get(i));
        }


    }

    public void removeClickedCard(int index){ //kommer behövas ändras så att kortet ersätts med ett "space" (space och kort borde ha samma interface!)
        activeCardList.remove(index);
    }

    public void showCards(){
        hideCards = false;
    }

    public void hideCards(){
        hideCards = true;
    }

    public boolean getHideCards(){
        return hideCards;
    }

    public List<Card> getActiveCardList() {
        return activeCardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getNumberOfShapes() {
        return numberOfActiveShapes;
    }

}
