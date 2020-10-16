package chalmers.app.model.Boards;

import chalmers.app.model.Boards.AbstractBoard;
import chalmers.app.model.Card;

import java.util.ArrayList;
import java.util.Collections;

public class FrenzyBoard extends AbstractBoard {

    /**
     *
     * Constructor
     * Fills a list with all different shapes
     * Shuffles the list and creates a board with the first X shapes
     */
    public FrenzyBoard(int level) {
        fillAllCardsList();
        generateBoard(level);
    }

    @Override
    public void correctCard() {

    }

    @Override
    public void incorrectCard() {

    }

    /**
     * Method for generating a board for the frenzy gamemode. Creates a list of cards, with several of the same kind.
     * @param currentLevel
     */
    @Override
    public void generateBoard(int currentLevel) {
        numberOfActiveShapes = 2 + currentLevel / 3;
        activeCardList = new ArrayList<>();
        int remainder = currentLevel + 5;
        // Only shapes on the board are active
        for (int i = 0; i < numberOfActiveShapes; i++) {
            int j = 0;

            while(j < 3){
                Card temp = new Card(allCardsList.get(i).getColor(), allCardsList.get(i).getShape());
                activeCardList.add(temp);
                if((remainder) % 3 > 0) {
                    Card temp2 = new Card(allCardsList.get(i).getColor(), allCardsList.get(i).getShape());
                    activeCardList.add(temp2);
                    remainder--;
                }
                j++;
            }
        }
        Collections.shuffle(activeCardList);
    }


}
