package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeSelector {
    private List<Shape> shapeList = new ArrayList<Shape>();
    private int selectedListItem = 0;

    /**
     *
     * Constructor
     * Has a shuffled list with the shapes currently on the field
     */
    public ShapeSelector(List<Shape> shapeList, int listLength) {

        for(int i = 0; i < listLength; i++){
            this.shapeList.add(shapeList.get(i));
        }
        Collections.shuffle(shapeList);
    }

    /**
     * Should be called after player scores
     */

    public void changeSelectedShape(){
        if(selectedListItem < shapeList.size()){
            selectedListItem++;
        } else {
            System.out.println("SelectedListItem is out of bounds!!");
        }
        //TODO Change the GUI image of selectedshape

    }

    public Shape getSelectedShape(){
        return shapeList.get(selectedListItem);
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
}
