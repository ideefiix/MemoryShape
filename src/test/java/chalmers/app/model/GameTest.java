package chalmers.app.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class GameTest {

    /**
     * Test run for the game
     */

    Game testGame = new Game(new Player("Nappe",3),1);

    /**
     * The player clicks on a wrong card:
     */
    @Test
    public void testWrongCard(){

        Card selectedCard = testGame.getBoard().getActiveCardList().get(0);
        Card clickedCard = testGame.getBoard().getActiveCardList().get(1);

        testGame.getCardSelector().setSelectedCard(selectedCard);

        int lifes_before = testGame.getPlayer().getLives();
        testGame.onClick(clickedCard);
        int lifes_after = testGame.getPlayer().getLives();
        //Player lose 1 life
        assertEquals(1,lifes_before - lifes_after);

    }
    @Test

    /**
     * Error 09/29. Card is not removed when pressed on?
     * Probably easy fix
     */
    public void testRightCard(){
        Card selectedCard = testGame.getBoard().getActiveCardList().get(2);

        testGame.getCardSelector().setSelectedCard(selectedCard);

        int lifes_before = testGame.getPlayer().getLives();
        int shape_onboard = testGame.getBoard().getActiveCardList().size();
        testGame.onClick(selectedCard);
        int lifes_after = testGame.getPlayer().getLives();
        int shape_onboard2 = testGame.getBoard().getActiveCardList().size();
        //Player keep lifes
        assertEquals(0,lifes_before - lifes_after);
        //Card is gone
        assertEquals(1, shape_onboard - shape_onboard2);


    }
}
