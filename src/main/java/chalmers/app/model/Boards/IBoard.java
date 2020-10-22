/**
 * Authors: Kevin
 * Responsibility: An interface used to achieve a weaker dependency on the board classes
 * Used by: Game
 * Uses: ICard
 */

package chalmers.app.model.Boards;
import chalmers.app.model.ICard;
import chalmers.app.model.ICardIterator;
import chalmers.app.model.IterableCards;
import java.util.List;

public interface IBoard extends IterableCards {

    void generateBoard(int currentLevel);

    void flipIncorrectCards();

    boolean isLevelComplete();
     
    List<ICard> getActiveCardList();

    void correctCard(ICard selectedCard);

    void incorrectCard(ICard selectedCard);

    ICardIterator createIterator();







}
