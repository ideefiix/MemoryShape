package chalmers.app.model;

import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;

public class Card implements ICard{

    private CardState state;
    private Color color;
    private Shape shape;



    public Card(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public Card(Color color, Shape shape, CardState state) {
        this.state = state;
        this.color = color;
        this.shape = shape;
    }


    /**
     * Compares if two cards are the same
     * in this case meaning having the same shape and color
     */
    public boolean equals(Card other) {
        return (this.color == other.color && this.shape == other.shape);
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    /**
     * Returns the ID of the card. The ID is simply a combination of the
     * color and the shape.
     * Used to match the card to an image in the boardController class
     */
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
