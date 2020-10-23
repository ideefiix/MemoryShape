/**
 * Authors: Kevin
 * Responsibility: A less mutable interface for the Card class.
 * Used by: Game, BoardController, CardController, CardIterator, ICardIterator, ICard , all classes in the Boards and CardDisplays packages
 * Uses: Color, Shape, CardState, Card, ICard
 */

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

    Card getMutableCard();

    boolean equals(ICard card);

}
