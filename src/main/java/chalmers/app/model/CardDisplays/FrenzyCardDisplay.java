package chalmers.app.model.CardDisplays;

import chalmers.app.model.Card;

import java.util.List;

class FrenzyCardDisplay extends AbstractCardDisplay {

    //Osynliga instansvariabler:
    //cardsToDisplay
    //nextDisplayCards
    //expectedCard
    //correctCardSelected



    @Override
    public void cardSelected(Card selectedCard) {



    }

    @Override
    public void setUp(List<Card> cardsToDisplay) {

        /*
        Ska jämföra selectedCard med expectedCard.
        Om det är rätt så ska expectedCard bli nästa förväntade kort och correctCardSelected ska sättas till true
        i simon says behöver inte nextDisplayCards updateras förrän leveln är avklarad.


         */

    }



}
