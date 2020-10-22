/**
 * Authors: Kevin
 * Responsibility: Represents the board of cards used in the Frenzy mode of the game
 * Used by: Game
 * Uses: Card
 */
package chalmers.app.model.Boards;

import chalmers.app.model.Card;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class for the board used in the Frenzy mode
 */
public class FrenzyBoard extends AbstractBoard {


    public FrenzyBoard(int level) {
        fillAllCardsList();
        generateBoard(level);
    }


    /**
     * Method for generating a board for the frenzy gamemode. Creates a list of cards, with several of the same kind.
     * @param currentLevel: the current level of the game
     */
    @Override
    public void generateBoard(int currentLevel) {
        nActiveCards = 2 + (currentLevel - 1) / 3;
        activeCardList = new ArrayList<>();
        int remainder = currentLevel + 5;
        // Only shapes on the board are active
        for (int i = 0; i < nActiveCards; i++) {
            int j = 0;
            while(j < 3){
                Card temp = new Card(allCardsList.get(i).getColor(), allCardsList.get(i).getShape(), allCardsList.get(i).getState());
                activeCardList.add(temp);
                if((remainder) % 3 > 0) {
                    Card temp2 = new Card(allCardsList.get(i).getColor(), allCardsList.get(i).getShape(),allCardsList.get(i).getState());
                    activeCardList.add(temp2);
                    remainder--;
                }
                j++;
            }
        }
        Collections.shuffle(activeCardList);
    }


}
