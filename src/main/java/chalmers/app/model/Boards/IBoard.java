/**
 * Authors: Kevin, Nils
 * Responsibility: An interface used to achieve a weaker dependency on the board classes
 * Used by: Game
 * Uses: ICard
 */
package chalmers.app.model.Boards;

import chalmers.app.model.ICard;
import chalmers.app.model.ICardIterator;
import java.util.List;

public interface IBoard {

    void generateBoard(int currentLevel);

    void flipIncorrectCards();

    boolean isLevelComplete();
     
    List<ICard> getActiveCardList();

    void correctCard(ICard selectedCard);

    void incorrectCard(ICard selectedCard);

    ICardIterator createIterator();

}
