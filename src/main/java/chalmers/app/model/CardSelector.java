package chalmers.app.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardSelector {
    private List<Card> cardList;
    private int selectedCardIndex = 0;
    private Card selectedCard;

    /**
     *
     * Constructor
     */
    public CardSelector(List<Card> cardList) {

        restartList(cardList);
    }

    /**
     * Should be called after player scores
     */

    public void changeSelectedShape(){
        if(selectedCardIndex < cardList.size()){
            selectedCardIndex++;
            selectedCard = cardList.get(selectedCardIndex);
        } else {
            System.out.println("SelectedShapeIndex is out of bounds!!");
        }
        //TODO Change the GUI image of selectedshape

    }

    /**
     * Creates a shuffled list with the shapes currently on the field
     * Picks a selectedCard
     */
    public void restartList(List<Card> ActivecardList){
        cardList = new ArrayList<>();

        for(Card card: ActivecardList){
            cardList.add(card);
        }

        Collections.shuffle(cardList);
        selectedCardIndex = 0;
        selectedCard = cardList.get(selectedCardIndex);
    }


    public Card getSelectedCard(){
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public List<Card> getCardList() {
        return cardList;
    }
}
