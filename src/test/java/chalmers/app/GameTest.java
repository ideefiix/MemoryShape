package chalmers.app;
import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;
import chalmers.app.model.Game;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTest {

    Game gametest = new Game("Amanda", Game.GameMode.STANDARD);
    Card expectedCard = new Card(Color.PINK, Shape.DIAMOND, CardState.FACEUP);
    Card selectedCard = new Card(Color.PINK, Shape.DIAMOND,CardState.FACEUP);



    @Test
    public void testOnClick(){
        /*gametest.getCardDisplay().setExpectedCard(expectedCard);
        gametest.onClick(selectedCard);
        assertTrue(gametest.getPlayer().getCurrentScore()==1);
        assertTrue(selectedCard.getState().equals(CardState.CORRECT));*/
    }
}
