package chalmers.app.model;

import chalmers.app.model.enums.Color;
import chalmers.app.model.enums.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    /**
     * Tests methods for Board
     */

    Board board = new Board(1);


    /**
     * All shapes is created
     */
   @Test
   public void createShapeList(){
       int colors = Color.values().length;
       int shapes = Shape.values().length;
       assertTrue(board.getCardList().size() == (colors*shapes));
   }


    @Test
    public void generateBoard() {

    }


}
