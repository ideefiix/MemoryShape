package chalmers.app.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp Cards
 */
public class CardSelector implements ICardSelector{
    private List<Card> cardList;
    private int selectedCardIndex = 0;
    private Card selectedCard;
    private boolean boardCleared = false;

    /**
     * Constructor
     */
    public CardSelector(List<Card> cardList) {

        restartList(cardList);
    }

    /**
     * Should be called after player scores
     */
    @Override
    public void changeSelectedCard(){
        if(selectedCardIndex + 1 < cardList.size()){
            selectedCardIndex++;
            selectedCard = cardList.get(selectedCardIndex);
        } else {
            boardCleared = true;
        }
        //TODO Change the GUI image of selectedshape

    }

    /**
     * Tar in en lista med Cards som den byter ut den gamla listan mot och sen shufflar
     * @param activeCardList
     */
    @Override
    public void restartList(List<Card> activeCardList){
        cardList = new ArrayList<>();

        for(Card card: activeCardList){
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
    public boolean isBoardCleared(){
        return boardCleared;
    }

    public void setBoardCleared(Boolean state){
        boardCleared = state;
    }
}
