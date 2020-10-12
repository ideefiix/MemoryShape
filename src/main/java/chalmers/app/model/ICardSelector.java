package chalmers.app.model;

import java.util.List;

public interface ICardSelector {

   void changeSelectedCard();
   void restartList(List<Card> activeCardList);
   Card getSelectedCard();
   void setSelectedCard(Card selectedCard);
}
