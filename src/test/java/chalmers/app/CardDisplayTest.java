/**
 * Authors: Edenia, Kevin, Nils
 * TestClass for the different CardDisplays
 */
package chalmers.app;

import chalmers.app.model.Boards.FrenzyBoard;
import chalmers.app.model.Card;
import chalmers.app.model.CardDisplays.FrenzyCardDisplay;
import chalmers.app.model.CardDisplays.SequenceCardDisplay;
import chalmers.app.model.CardDisplays.StandardCardDisplay;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;
import chalmers.app.model.ICard;
import chalmers.app.model.ICardIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardDisplayTest {

    StandardCardDisplay cardDisplay = new StandardCardDisplay();
    FrenzyCardDisplay frenzyCardDisplay = new FrenzyCardDisplay();
    SequenceCardDisplay sequenceCardDisplay = new SequenceCardDisplay();
    ICard expectedCard = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    ICard selectedCard = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    ICard card1 = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    ICard card2 = new Card(Color.ORANGE, Shape.CIRCLE, CardState.FACEUP);
    ICard card3 = new Card(Color.GREEN, Shape.RECTANGLE, CardState.FACEUP);
    ICard card4 = new Card(Color.YELLOW, Shape.STAR, CardState.FACEUP);
    ICard card5 = new Card(Color.PURPLE , Shape.TRIANGLE, CardState.FACEUP);
    List<ICard> cards = new ArrayList<>();

    public void fyllingList() {
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
    }


    @Test
    public void testCardSelected() {
        fyllingList();
        cardDisplay.setUp(cards);
        int n = cardDisplay.getCardsToDisplay().size();
        ICard card = cardDisplay.getNextDisplayCards().get(0);
        cardDisplay.setExpectedCard(expectedCard);
        cardDisplay.cardSelected(selectedCard);
        assertTrue(cardDisplay.isCorrectCardSelected());
        assertTrue(cardDisplay.getCardsToDisplay().size() == n - 1);
        assertFalse(cardDisplay.getNextDisplayCards().get(0).equals(card));
    }

    @Test
    public void testSetUp() {
        fyllingList();
        cardDisplay.setUp(cards);
        assertTrue(cardDisplay.getNextDisplayCards().get(0).equals(cardDisplay.getExpectedCard()));

    }

    @Test
    public void testSortCardsToDisplay() {
        FrenzyBoard frenzyBoard = new FrenzyBoard(10);
        frenzyCardDisplay.loadCardsToDisplay(frenzyBoard.getActiveCardList());
        frenzyCardDisplay.sortCardsToDisplay();
        List<ICard> testList = frenzyCardDisplay.getCardsToDisplay();
        List<ICard> shouldBeOneOfEach = new ArrayList<>();
        boolean methodSucceded = true;
        for(int i = 1; i < testList.size();i++){
            if(!testList.get(i).equals(testList.get(i - 1))){
                shouldBeOneOfEach.add(testList.get(i));
            }
        }
        for (int i = 0; i < shouldBeOneOfEach.size(); i++){
            for (int j = i + 1; j < shouldBeOneOfEach.size(); j++){
                if(shouldBeOneOfEach.get(i).equals(shouldBeOneOfEach.get(j))){
                    methodSucceded = false;
                }
            }
        }
        assertTrue(methodSucceded);
    }

    @Test
    public void testSsSetUp() {
        fyllingList();
        sequenceCardDisplay.setUp(cards);
        assertTrue(sequenceCardDisplay.getNextDisplayCards().get(0).equals(sequenceCardDisplay.getExpectedCard()));
    }

    @Test
    public void testSsCardSelected() {
        sequenceCardDisplay.setExpectedCard(expectedCard);
        sequenceCardDisplay.cardSelected(selectedCard);
        assertTrue(sequenceCardDisplay.isCorrectCardSelected());
        sequenceCardDisplay.setExpectedCard(card2);
        sequenceCardDisplay.cardSelected(selectedCard);
        assertFalse(sequenceCardDisplay.isCorrectCardSelected());
        assertTrue(sequenceCardDisplay.getNextDisplayCards().get(0).equals(selectedCard));
    }

    @Test
    public void testFrenzySetUp() {
        fyllingList();
        frenzyCardDisplay.setUp(cards);
        assertTrue(frenzyCardDisplay.getNextDisplayCards().get(0).equals(frenzyCardDisplay.getExpectedCard()));
    }

    @Test
    public void testCreateIterator() {
        fyllingList();
        cardDisplay.setUp(cards);
        assertTrue(cardDisplay.createIterator().getCard().equals(cardDisplay.getNextDisplayCards().get(0)));
        frenzyCardDisplay.setUp(cards);
        assertTrue(frenzyCardDisplay.createIterator().getCard().equals(frenzyCardDisplay.getNextDisplayCards().get(0)));
        sequenceCardDisplay.setUp(cards);
        boolean iteratorDiffers = false;
        ICardIterator sequenceIterator = sequenceCardDisplay.createIterator();
        for (int i = 0;i < sequenceCardDisplay.getNextDisplayCards().size();i++){
            if(!sequenceIterator.getCard().equals(sequenceCardDisplay.getNextDisplayCards().get(i))){
                iteratorDiffers = true;
            }
            sequenceIterator.step();
        }
        assertFalse(iteratorDiffers);
    }
}
