package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;

import java.util.List;

/**
 * Klass för den display som visar upp sekvensen av Cards i Simon Says game modet
 */
public class SimonSaysCardDisplay extends AbstractCardDisplay {

    //Osynliga instansvariabler:
    //cardsToDisplay
    //nextDisplayCards
    //expectedCard
    //correctCardSelected


    @Override
    public void cardSelected(Card selectedCard) {
        /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true
        i simon says behöver inte nextDisplayCards updateras förrän leveln är avklarad.


         */

    }

    @Override
    public void setUp(List<Card> cardsToDisplay) {

    }




    /**
     * Constructor
     * @param cardList lista med Cards som ska visas upp
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



}
