package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

    private MainController mainController;
    private Game game;
    private List<CardController> cardControllers = new ArrayList<CardController>();
    File dir = new File("src/main/resources/view/images/shapes");
    private List<Card> displayCards;
    private int indexImage = 0;

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


    public BoardController(MainController mainController, Game game, List< Card > DisplayCards) {
        this.mainController = mainController;
        this.game = game;
        displayCards = DisplayCards;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCards();
        updateBoard();
        hideCards();
        setNextDisplayImage();

    }




    /**
     * Create the cards FXMLs
     */
    public void createCards (){
        List<Card> cardList = game.getBoard().getActiveCardList();

        for(int i = 0; i < cardList.size(); i ++){
            cardControllers.add( new CardController(this, cardList.get(i)));
            assignImage(cardList.get(i).getID(), cardControllers.get(i));
        }
    }

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


    /**
     * Creates a list of Images from a list of card IDs
     */
    public void setSelectedCard() {
        Card selected = game.getCardDisplay().getSelectedCard();
        assignImageCardDisplay();
    }

        public void setNextDisplayImage () {
            if (indexImage < displayCards.size()) {
                selectedCard.setImage(assignImageCardDisplay());
                indexImage++;
            }
        }

        public Image assignImageCardDisplay () {
            Image i = null;
            Card c = displayCards.get(indexImage);

            for (File file : dir.listFiles()) {
                //Remove .JPG extension
                String str = file.getName();
                int pos = str.lastIndexOf(".");

                if (str.substring(0, pos).equals(c.getID())) {
                    i = new Image(file.toURI().toString());

                    break;
                }

            }
            if (i == null) {
                System.out.println("Something ain't right in BC cardDisplay");
                System.out.println(c.getID());
            }
            return i;

        }

        /**
         * Makes the cardshapes invincible
         */

        public void hideCards () {
            for (CardController cc : cardControllers) {
                cc.hideImage();
            }

        }

        public Game getGame () {
            return game;
        }

        public void incScore () {
            game.getPlayer().incScore();
        }

        public void bcDecLife () {
            game.getPlayer().decLife();
        }

        public void onclick (Card card){
            mainController.onClick(card);
        }

        public List<CardController> getCardControllers () {
            return cardControllers;
        }

        public void isBoardCleared () {
            if (game.getBoardCleared()) {
                game.incLevel();
                game.newBoard();
                game.setBoardCleared(false);
                cardControllers = new ArrayList<>();
                createCards();
                updateBoard();
                hideCards();
                // Fix cardDisplay
                displayCards = game.getCardDisplay().getCardList();
                indexImage = 0;
                setNextDisplayImage();

            }
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

        public void gameOver () {
            int lives = game.getPlayer().getLives();
            if (lives <= 0) {
                populateGameOverLabel();
                gameOverAnchorPane.toFront();

            }
        }

        @FXML
        private void mainMenuButtonPressed () {
            mainController.setMenuScene();
        }

        @FXML
        private void newGameButtonPressed () {
            mainController.setBoardScene();
        }

        public void populateGameOverLabel () {
            gameOverLabel.setText(" You reached level " + String.valueOf(game.getLevel()) + " and you scored " + String.valueOf(game.getPlayer().getCurrentScore()) + " points ");
        }

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



}
