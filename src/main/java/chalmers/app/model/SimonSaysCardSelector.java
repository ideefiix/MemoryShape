package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Klass för den display som visar upp sekvensen av Cards i Simon Says game modet
 */
public class SimonSaysCardSelector implements ICardSelector {
    private List<Card> cardList;
    private int selectedCardIndex = 0;
    private Card selectedCard;

    /**
     * Constructor
     * @param cardList lista med Cards som ska visas upp
     */
    public SimonSaysCardSelector(List<Card> cardList) {

        restartList(cardList);
    }

    /**
     * Visar sekvensen kort på displayen
     */
    @Override
    public void changeSelectedCard() {
        while(selectedCardIndex < cardList.size()) {
            selectedCardIndex++;
            selectedCard = cardList.get(selectedCardIndex);
            Thread thread = new Thread(){
                public void run(){
                    try{
                        Thread.sleep(5000);
                    }catch (Exception e){

                    }
                }
            };
            thread.start();
        }
        //selectedCard = visa ett blankt kort
    }

    /**
     * Tar in en lista med Cards som den byter ut den gamla listan mot och sen shufflar
     * @param activeCardList
     */
    @Override
    public void restartList(List<Card> activeCardList) {
        cardList = new ArrayList<>();

        for(Card card: activeCardList){
            cardList.add(card);
        }

        Collections.shuffle(cardList);
        selectedCardIndex = 0;
        selectedCard = cardList.get(selectedCardIndex);
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Card getSelectedCard() {
        return selectedCard;
    }

    @Override
    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }
}
