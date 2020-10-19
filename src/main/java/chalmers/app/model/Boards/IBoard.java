package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import chalmers.app.model.IterableCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IBoard extends IterableCards {

    void generateBoard(int currentLevel);

    void flipIncorrectCards();

    boolean isLevelComplete();
     
    List<Card> getActiveCardList();

    int getNumberOfShapes();

    void correctCard(Card selectedCard);

    void incorrectCard(Card selectedCard);

    void fillAllCardsList();




}
