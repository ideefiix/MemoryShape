package chalmers.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klass för den display som visar upp sekvensen av Cards i Simon Says game modet
 */
public class SimonSaysCardDisplay extends AbstractCardDisplay {


    /**
     * Constructor
     * @param cardList lista med Cards som ska visas upp
     */
    public SimonSaysCardDisplay(List<Card> cardList) {

        restartList(cardList);
    }

    /**
     * Visar sekvensen kort på displayen
     */
/*
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

 */

    /**
     * Tar in en lista med Cards som den byter ut den gamla listan mot och sen shufflar
     * @param activeCardList
     */




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
    public void cardSelected(Card card) {

    }

    @Override
    public boolean isCorrectCardSelected() {
        return false;
    }
}
