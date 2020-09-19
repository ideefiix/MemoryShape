package chalmers.app.model;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
   private List<Shape> shapeList;
   private ShapeSelector shapeSelector;
   private int numberOfShapes;
   private int currentLevel;

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public Board( int currentLevel) {
        this.currentLevel = currentLevel;

        fillShapeList();
        generateBoard(this.currentLevel);
    }

    //Methods

    /**
     * Creates the shapes with the images in the folder
     * Does not work atm!!
     */

    public void fillShapeList(){
        shapeList = new ArrayList<Shape>();
        File dir = new File("D:\\Java-Time\\MemoryShape\\MemoryShape\\src\\main\\java\\chalmers\\app\\model\\images");

        if(dir.isDirectory()){
            for (File imgFile: dir.listFiles()){
                Image image = new ImageIcon(imgFile.getPath()).getImage();
                shapeList.add(new Shape(image));
            }
        } else{
            throw new IllegalArgumentException("It's not a directory!");
        }



    }

    public void generateBoard(int currentlevel){
        numberOfShapes = 3 + (currentlevel * 1);
        Collections.shuffle(shapeList);
        /**
         * ShapeSelector copies the list but only saves the shapes currently on the board
         */
        shapeSelector = new ShapeSelector(shapeList, numberOfShapes);

        for(int i = 0; i < numberOfShapes; i++){
            //TODO Call a method in the controller to create GUI cards with the shapes
        }


    }

    public void clickedShape(Shape shape){
        if(shape.getShapeSelected() == true){

            changeSelectedShape(shape);
            //TODO Give player score, make shape blank?

        }else{
            //TODO Take life of player, game over?
        }
    }

    public void changeSelectedShape(Shape shape){
        //Remove old
        shapeSelector.changeSelectedShape();
        int updateShapeStatus = shapeList.indexOf(shape);
        shapeList.get(updateShapeStatus).setShapeSelected(false);

        //Set new
        for(int i = 0; i < shapeList.size(); i++){
            if (shapeList.get(i).getImage() == shapeSelector.getSelectedShape().getImage()){
                shapeList.get(i).setShapeSelected(true);
            }
        }
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public ShapeSelector getShapeSelector() {
        return shapeSelector;
    }

    public int getNumberOfShapes() {
        return numberOfShapes;
    }
}
