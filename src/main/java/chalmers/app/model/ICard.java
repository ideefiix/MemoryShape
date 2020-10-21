package chalmers.app.model;


import chalmers.app.model.CardEnums.CardState;
import chalmers.app.model.CardEnums.Color;
import chalmers.app.model.CardEnums.Shape;

/**
 * A less mutable interface for the Card class used both inside and outside of the model
 */
public interface ICard {
    Color getColor();
    Shape getShape();
    CardState getState();
    String getID();
    void setCorrect();
    void setIncorrect();
    void setFaceUp();
    void setFaceDown();
    boolean equals(ICard card);
}
