/**
 *
 */

package chalmers.app.model.CardDisplays;

import chalmers.app.model.ICard;
import chalmers.app.model.ICardIterator;
import java.util.List;

public interface ICardDisplay {

    void cardSelected(ICard card);

    boolean isCorrectCardSelected();

    void setUp(List<ICard> cardsToDisplay);

    ICardIterator createIterator();

}
