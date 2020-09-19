package chalmers.app.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    /**
     * Tests methods in Board
     * Tests will fail if number of images is changed!
     */

    Board board = new Board(1);


    @Test
    public void fillShapeList() {
        assertTrue(board.getShapeList().size() == 4);

    }

    @Test
    public void generateBoard() {
        assertTrue(board.getShapeSelector().getShapeList().size() == board.getNumberOfShapes() );
    }

    @Test
    public void changeSelectedShape() {
        //Old selectedShape is no longer selected
        Shape oldselected = board.getShapeSelector().getSelectedShape();
        board.changeSelectedShape(board.getShapeSelector().getSelectedShape());
        assertTrue(oldselected.getShapeSelected() == false);

        //A new shape is selected
        boolean foundSelectedShape = false;
        for (int i = 0; i < board.getShapeList().size(); i++){
            if(board.getShapeList().get(i).getShapeSelected() == true){
                foundSelectedShape = true;
            }
        }
        if (foundSelectedShape){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }
}
