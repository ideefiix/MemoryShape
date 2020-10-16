package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface IBoard {

    void createShapeList();

    List<String> getIds();

    void generateBoard(int currentLevel);

    void removeClickedCard(int index);

    void showCards();

    void hideCards();

    boolean getHideCards();

    List<Card> getActiveCardList();

    List<Card> getAllCardsList();

    int getNumberOfShapes();

}
