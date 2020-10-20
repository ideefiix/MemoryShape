package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;
import javafx.print.Collation;

import java.util.Collections;
import java.util.List;

public class FrenzyCardDisplay extends AbstractCardDisplay {

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
    public void setUp(List<Card> cards) {
        for(Card c : cards){
            cardsToDisplay.add(new Card(c.getColor(),c.getShape()));
        }
        Collections.shuffle(cardsToDisplay);
    }

    public List<Card> getCardList(){
        return cardsToDisplay;
    }



}
