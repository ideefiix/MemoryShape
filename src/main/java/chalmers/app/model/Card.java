package chalmers.app.model;

import chalmers.app.model.enums.Color;
import chalmers.app.model.enums.Shape;

import java.util.Objects;

public class Card {

    private Color color;
    private Shape shape;
    private boolean isSelected = false;
    int size = 1;

    public Card(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }


    public boolean equals(Card other) {
        return (this.color == other.color && this.shape == other.shape);
    }



    public boolean getShapeSelected(){
        return isSelected;
    }

    public void setShapeSelected(boolean setting){
        isSelected = setting;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }
}
