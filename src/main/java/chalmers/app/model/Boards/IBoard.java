package chalmers.app.model.Boards;

import chalmers.app.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface IBoard {

    void generateBoard(int currentLevel);

    void flipIncorrectCards();

    boolean isLevelComplete();
     
    List<Card> getActiveCardList();

    int getNumberOfShapes();

    void correctCard(Card selectedCard);

    void incorrectCard(Card selectedCard);

    void fillAllCardsList();


}
