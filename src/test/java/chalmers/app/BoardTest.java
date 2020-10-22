/**
 * Authors: Edenia
 * Test class for the different boards
 */
package chalmers.app;

import chalmers.app.model.Boards.AbstractBoard;
import chalmers.app.model.Boards.FrenzyBoard;
import chalmers.app.model.Boards.SequenceBoard;
import chalmers.app.model.Boards.StandardBoard;
import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;
import chalmers.app.model.ICard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import  static org.junit.Assert.assertTrue;

public class BoardTest {

    StandardBoard board = new StandardBoard(2);
    FrenzyBoard boardFrenzy = new FrenzyBoard(1);
    SequenceBoard boardSimonSays = new SequenceBoard(1);
    Card card1 = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEDOWN);
    Card card2 = new Card(Color.ORANGE,Shape.CIRCLE,CardState.FACEDOWN);
    Card card3 = new Card(Color.GREEN,Shape.RECTANGLE,CardState.FACEDOWN);

    @Test
    public void testIsLevelComplete(){
        assertFalse(board.isLevelComplete());
        setCardState(board);
        assertTrue(board.isLevelComplete());
    }

    public void setCardState(AbstractBoard board){
      for(ICard card : board.getActiveCardList()){
          board.correctCard(card);
      }
    }



    @Test
    public void testGenerateBoard(){
     assertTrue(board.getActiveCardList().get(0).getState().equals(CardState.FACEDOWN));
    }



    @Test
    public void testFlipIncorrectCards(){ //borde kolla så alla kort som var incorrect har ändrats till
      setIncorrectState(board);
      board.flipIncorrectCards();
      assertTrue(board.getActiveCardList().get(0).getState().equals(CardState.FACEDOWN));
      setCardState(board);
      board.flipIncorrectCards();
      assertTrue(board.getActiveCardList().get(0).getState().equals(CardState.CORRECT));
    }

    public void setIncorrectState(AbstractBoard board){
      for(ICard card : board.getActiveCardList()){
          board.incorrectCard(card);
      }
    }

    @Test
    public void testGenerateBoardFrenzy(){
      assertTrue(isDuplicated());
    }


    public boolean isDuplicated(){
      ICard card = boardFrenzy.getActiveCardList().get(1);
      for(int i =0; i < boardFrenzy.getActiveCardList().size();i++){
          if(card.equals(boardFrenzy.getActiveCardList().get(i))){
              return true;
          }
      } return false;
    }

    @Test
    public void testGenerateBoardSimonSays(){
      assertTrue(boardSimonSays.getActiveCardList().get(0).getState().equals(CardState.FACEUP));
    }

    @Test
    public void testFlipIncorrectCardSS(){
      setIncorrectState(boardSimonSays);
      boardSimonSays.flipIncorrectCards();
      assertTrue(boardSimonSays.getActiveCardList().get(0).getState().equals(CardState.FACEUP));
      setCardState(boardSimonSays);
      boardSimonSays.flipIncorrectCards();
      assertTrue(boardSimonSays.getActiveCardList().get(0).getState().equals(CardState.CORRECT));
    }




}
