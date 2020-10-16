package chalmers.app.model;

import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;

public class Card {

    private CardState state;
    private Color color;
    private Shape shape;
    private boolean isFlipped = false;
    private boolean removed = false;
    int size = 1;

    public Card(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public Card(Color color, Shape shape, CardState state) {
        this.state = state;
        this.color = color;
        this.shape = shape;
    }

    public boolean equals(Card other) {
        return (this.color == other.color && this.shape == other.shape);
    }

    public boolean getisRemoved(){
        return removed;
    }

    public void setisRemoved(boolean state){
        removed = state;
    }

    public boolean getFlipped(){
        return isFlipped;
    }

    public void setFlipped(boolean state){
        isFlipped = state;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public String getID(){
        return (color.toString() + shape.toString());
    }

    public void setState(CardState state) {
        this.state = state;
    }

    public CardState getState() {
        return state;
    }
}
