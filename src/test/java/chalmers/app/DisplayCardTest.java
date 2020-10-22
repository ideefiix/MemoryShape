package chalmers.app;

import chalmers.app.model.Card;
import chalmers.app.model.CardDisplays.FrenzyCardDisplay;
import chalmers.app.model.CardDisplays.SimonSaysCardDisplay;
import chalmers.app.model.CardDisplays.StandardCardDisplay;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DisplayCardTest {

    StandardCardDisplay cardDisplay = new StandardCardDisplay();
    FrenzyCardDisplay frenzyCardDisplay = new FrenzyCardDisplay();
    SimonSaysCardDisplay simonSaysCardDisplay = new SimonSaysCardDisplay();
    Card expectedCard = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    Card selectedCard = new Card(Color.PINK, Shape.DIAMOND,CardState.FACEUP);
    Card card1 = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    Card card2 = new Card(Color.ORANGE,Shape.CIRCLE,CardState.FACEUP);
    Card card3 = new Card(Color.GREEN,Shape.RECTANGLE,CardState.FACEUP);
    Card card4 = new Card(Color.YELLOW,Shape.STAR,CardState.FACEUP);
    Card card5 = new Card(Color.PINK,Shape.DIAMOND,CardState.FACEUP);
    List<Card> cards = new ArrayList<>();

    public void fyllingList(){
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
    }


    @Test
    public void testCardSelected(){
        cardDisplay.setExpectedCard(expectedCard);
        cardDisplay.cardSelected(selectedCard);
        assertTrue(cardDisplay.isCorrectCardSelected());
    }

    @Test
    public void testSetUp(){
        fyllingList();
        cardDisplay.setUp(cards);
        assertTrue(cardDisplay.getNextDisplayCards().get(0).equals(cardDisplay.getExpectedCard()));

    }

    @Test
   public void testSortCardsToDisplay(){
        fyllingList();
        frenzyCardDisplay.setCardsToDisplay(cards);
        frenzyCardDisplay.sortCardsToDisplay();
        assertTrue(frenzyCardDisplay.getCardsToDisplay().get(0).equals(frenzyCardDisplay.getCardsToDisplay().get(1)));
    }

    @Test
    public void testSsSetUp(){
        fyllingList();
        simonSaysCardDisplay.setUp(cards);
        assertTrue(simonSaysCardDisplay.getNextDisplayCards().get(0).equals(simonSaysCardDisplay.getExpectedCard()));
    }

    @Test
    public void testSsCardSelected(){
        simonSaysCardDisplay.setExpectedCard(expectedCard);
        simonSaysCardDisplay.cardSelected(selectedCard);
        assertTrue(simonSaysCardDisplay.isCorrectCardSelected());
    }


}
