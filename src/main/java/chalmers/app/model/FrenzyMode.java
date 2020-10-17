package chalmers.app.model;

public class FrenzyMode implements IGameMode {

    private Board board;
    private Card currentCard; //kanske ska va index
    private boolean correctCardSelected;
    private boolean levelCompleted;
    private boolean gameCompleted;
    private int displayIndex = 0;









    @Override
    public void startUp() {
        //board.fillFrenzy(int level) level kan va 1
        //display.fill(Board board) behöver inte heta fill
        //currentCard = display.getList.get(displayIndex) <-- Första kortet i listan.
    }

    @Override
    public void cardSelected(int index) { //kanske kan ta in board och cardDisplay
        if(compareCards(index)){
            correctCardSelected = true;
        }

        if(currentCardCleared()) {
            //if(displayIndex < display.getList.size){
            //displayIndex++;
            //currentCard = display.getList.get(displayIndex);
            //}
        }
    }

    @Override
    public boolean isCorrectCard() {
        return correctCardSelected;
    }

    @Override
    public boolean levelCompleted() {
        return levelCompleted;
    }

    @Override
    public void nextLevel() {

    }

    private boolean currentCardCleared(){
        boolean cardCleared = true;
        for(Card c: board.getActiveCardList()){
            if(c.equals(currentCard) && !c.isRevealed()){
                cardCleared = false;
            }
        }
        return cardCleared;
    }

    private boolean compareCards(int index){
        return board.getActiveCardList().get(index).equals(currentCard);
    }


}