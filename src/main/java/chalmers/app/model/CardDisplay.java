package chalmers.app.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp Cards
 */
public class CardDisplay{
    private List<Card> cardList;
    private int selectedCardIndex = 0;
    private Card selectedCard;
    private boolean PlayerGuessedAllCards = false;

    /**
     * Constructor
     */
    public CardDisplay(List<Card> cardList) {

        restartList(cardList);
    }

    /**
     * Should be called after player scores
     */

    public void changeSelectedCard(){
        if(selectedCardIndex + 1 < cardList.size()){
            selectedCardIndex++;
            selectedCard = cardList.get(selectedCardIndex);
        } else {
            PlayerGuessedAllCards = true;
        }
        //TODO Change the GUI image of selectedshape

    }

    /**
     * Tar in en lista med Cards som den byter ut den gamla listan mot och sen shufflar
     * @param activeCardList
     */

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

    public List<String> getIds(){
        List < String > colorShape = new ArrayList<>();
        for(int i = 0; i < cardList.size(); i++){
            String id = cardList.get(i).getColor().name() + cardList.get(i).getShape().name();
            colorShape.add(id);
        }
        return colorShape;
    }

    public boolean getPlayerGuessedAllCards(){
        return PlayerGuessedAllCards;
    }

    public void setPlayerGuessedAllCards(Boolean state){
        PlayerGuessedAllCards = state;
    }
}
