package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import chalmers.app.model.GameObserver;
import chalmers.app.model.ICardIterator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


import java.io.File;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable, GameObserver {

    private MainController mainController;
    private List<CardController> cardControllers = new ArrayList<CardController>();
    File dir = new File("src/main/resources/view/images/shapes");
    private List<Card> displayCards;

    public boolean newLevel = false;
    private ICardIterator displayIterator;

    @FXML
    AnchorPane pausedAnchorPane;
    @FXML
    AnchorPane boardAnchorPane;
    @FXML
    AnchorPane soundOptionsAnchorPane;

    @FXML
    FlowPane flowPane;
    @FXML
    ImageView selectedCard;
    @FXML
    AnchorPane gameOverAnchorPane;
    @FXML
    Label gameOverLabel;
    @FXML
    ImageView imageLife1;
    @FXML
    ImageView imageLife2;
    @FXML
    ImageView imageLife3;
    @FXML
    Button start_btn;


    public BoardController(MainController mainController, Game game, List< Card > DisplayCards) {
        this.mainController = mainController;
       // this.game = game;
        displayCards = DisplayCards;
    }

    public BoardController(MainController mainController){
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //createCards();
        updateBoard();
        hideCards();
        //setNextDisplayImage();
    }


    @FXML
    public void beginLevel(){
        if(newLevel) {
            start_btn.setVisible(false);
            hideCards();
            selectedCard.setVisible(true);
            playCardSequence();
            newLevel = false;
        }
    }

    private void playCardSequence(){
        while (displayIterator.hasNext()){
            setDisplayImage(displayIterator.getCard());
            delay1sec();
        }
    }

    private void delay1sec(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }







    /**
     * Create the cards FXMLs
     */
    /*
    public void createCards (){
        List<Card> cardList = game.getBoard().getActiveCardList();

        for(int i = 0; i < cardList.size(); i ++){
            cardControllers.add( new CardController(this, cardList.get(i)));
            assignImage(cardList.get(i).getID(), cardControllers.get(i));
        }
    }


     */

    /**
     * Is called by createCards()
     * Sets the cards Images on the board.
     */
    public void assignImage(String id, CardController cc){
        for(File file: dir.listFiles()){

            //Remove .JPG extension
            String str = file.getName();
            int pos = str.lastIndexOf(".");

            if(str.substring(0,pos).equals(id)){
                cc.setImage(file);
                break;
            }
        }
    }

    /**
     * Fills the board with cards
     */
    public void updateBoard(){
         flowPane.getChildren().clear();
        for(CardController cardController: cardControllers){
            flowPane.getChildren().add(cardController);
        }
    }






        public void setDisplayImage(Card card){
            selectedCard.setImage(assignImage(card));
        }

        public Image assignImage(Card c){
            Image i = null;
            for (File file : dir.listFiles()) {
                //Remove .JPG extension
                String str = file.getName();
                int pos = str.lastIndexOf(".");
                if (str.substring(0, pos).equals(c.getID())) {
                    i = new Image(file.toURI().toString());

                    break;
                }

            }
            return i;
        }


        /**
         * Makes the cardshapes invincible
         */

        public void hideCards () {
            for (CardController cc : cardControllers) {
                cc.hideImage();
                cc.setBackPliancy();
            }

        }

        public void showCards(){
            for(CardController cc: cardControllers){
                cc.showImage();
                cc.setNoPliancy();
            }
        }





        public void onclick (Card card){
            mainController.onClick(card);
        }

        public List<CardController> getCardControllers () {
            return cardControllers;
        }


        @FXML
        private void pausedButtonPressed () { //
            pausedAnchorPane.toFront();
        }

        @FXML
        private void resumeButtonPressed () {
            boardAnchorPane.toFront();
        }

        @FXML
        private void optionsButtonPressed () {
            soundOptionsAnchorPane.toFront();
        }

        @FXML
        private void quitButtonPressed () {
            mainController.getStage().close();
        }

        @FXML
        private void quitToMenuPressed () {
            mainController.setMenuScene();
        }

        @FXML
        private void backButtonPressed () {
            pausedAnchorPane.toFront();
        }



        @FXML
        private void mainMenuButtonPressed () {
            mainController.setMenuScene();
        }

        @FXML
        private void newGameButtonPressed () {
            mainController.setBoardScene();
        }

        /*
        public void populateGameOverLabel () {
            gameOverLabel.setText(" You reached level " + String.valueOf(game.getLevel()) + " and you scored " + String.valueOf(game.getPlayer().getCurrentScore()) + " points ");
        }

         */

        public void removeLifeImage () {
            int calls = 3;
            switch (calls) {
                case 3:
                    imageLife1.setImage(null);
                case 2:
                    imageLife2.setImage(null);
                case 1:
                    imageLife1.setImage(null);

            }
            calls--;


        }




        public void updateCardControllers(ICardIterator boardIterator){
            int i = 0;
            while (boardIterator.hasNext()){
                Card card = boardIterator.getCard();
                if(i < cardControllers.size()){
                    cardControllers.get(i).setCard(card);
                    cardControllers.get(i).setImage(assignImage(card));
                } else{
                    CardController newCC = new CardController(this, card);
                    newCC.setImage(assignImage(card));
                    cardControllers.add(newCC);
                }
                cardControllers.get(i).updateCardState();
                boardIterator.getNext();
                i++;
            }
            updateBoard();
        }

        public void updateCardDisplay(ICardIterator displayIterator){
            setDisplayImage(displayIterator.getCard());
        }



        private void newLevel(){
            showCards();
            selectedCard.setVisible(false);
            start_btn.setVisible(true);
            newLevel = true;
        }

        private void hideCardDisplay(){

        }

        private void game_over(){
            populateGameOverLabel();
            gameOverAnchorPane.toFront();
        }

    public void populateGameOverLabel () {
        gameOverLabel.setText(" You reached level " + String.valueOf(mainController.getLevel()) + " and you scored " + String.valueOf(mainController.getPlayer().getCurrentScore()) + " points ");
    }




    @Override
    public void update(ICardIterator diplayIterator, ICardIterator boardIterator){
        updateCardControllers(boardIterator);
        updateCardDisplay(diplayIterator);
        this.displayIterator = diplayIterator;
    }

    @Override
    public void update(String message) {
            switch (message){
                case "new_level": newLevel();
                break;

                case "game_over": game_over();
                break;
            }
            //Switch-sats för olika messages som gameover och gamecomplete. kanske displayCardDisplay
    }

}
