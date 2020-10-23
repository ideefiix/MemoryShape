/**
 * Authors: Kevin, Filip, Edenia
 * Responsibility: javaFX controller for board.fxml
 * Used by: MainController
 * Uses: ICard, ICardIterator, MainController, BoardController
 */
package chalmers.app.controller;

import chalmers.app.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import java.io.File;
import java.util.*;


public class BoardController implements GameObserver {

    private MainController mainController;
    private List<CardController> cardControllers = new ArrayList<CardController>();
    private File dir = new File("src/main/resources/view/images/shapes");
    private boolean newLevel = false;
    private ICardIterator displayIterator;
    private int lives = 3;


    @FXML
    AnchorPane pausedAnchorPane;
    @FXML
    AnchorPane boardAnchorPane;
    @FXML
    AnchorPane soundOptionsAnchorPane;
    @FXML
    FlowPane flowPane;
    @FXML
    ImageView cardDisplay;
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


    public BoardController(MainController mainController){
        this.mainController = mainController;
    }


    @FXML
    public void beginLevel() {
        if(newLevel) {
            //start_btn.setVisible(false);
            hideCards();
            cardDisplay.setVisible(true);
            newLevel = false;
        }
        if(displayIterator != null && (displayIterator.hasCard())){
            newLevel = true;
            showCards();
            setDisplayImage(displayIterator.getCard());
            if(!displayIterator.hasNext()){
                newLevel = false;
                cardDisplay.setImage(null);
                turnOnCardPliancy();
            }
            displayIterator.step();
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


    public void setDisplayImage(ICard card){
        cardDisplay.setImage(assignImage(card));
    }

    public Image assignImage(ICard c){
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


    private void hideCards () {
        for (CardController cc : cardControllers) {
            cc.hideImage();
            cc.turnOnPliancy();
        }
    }


    private void showCards(){
        for(CardController cc: cardControllers){
            cc.showImage();
            if(newLevel) {
                cc.turnOffPliancy();
            }
        }
    }


    private void turnOnCardPliancy(){
        for(CardController cc: cardControllers){
            cc.turnOnPliancy();
        }
    }


    public void onclick (ICard card){
        mainController.onClick(card);
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
        mainController.newGame();
        mainController.setBoardScene();
    }



    private void removeLifeImage () {
        lives--;
        switch (lives) {
            case 2:
                imageLife1.setImage(null);
                break;

            case 1:
                imageLife2.setImage(null);
                break;
            case 0:
                imageLife3.setImage(null);
                break;
        }

    }


    private void updateCardControllers(ICardIterator boardIterator){
        int i = 0;
        while (boardIterator.hasCard()){
            ICard card = boardIterator.getCard();
            if(i < cardControllers.size()){
                cardControllers.get(i).setCard(card);
                cardControllers.get(i).setImage(assignImage(card));
            } else{
                CardController newCC = new CardController(this, card);
                newCC.setImage(assignImage(card));
                cardControllers.add(newCC);
            }
            cardControllers.get(i).updateCardState();
            boardIterator.step();
            i++;
        }
        updateBoard();
    }


    private void updateCardDisplay(ICardIterator displayIterator){
            setDisplayImage(displayIterator.getCard());
        }


    private void newLevel(){
        newLevel = true;
        showCards();
        cardDisplay.setVisible(false);
        //start_btn.setVisible(true);
    }


    private void game_over(){
        mainController.sendNewScore();
        populateGameOverLabel();
        gameOverAnchorPane.toFront();
    }


    private void populateGameOverLabel () {
        gameOverLabel.setText(" You reached level " + String.valueOf(mainController.getLevel()) + " and you scored " + String.valueOf(mainController.getPlayer().getCurrentScore()) + " points ");
    }


    @Override
    public void update(ICardIterator displayIterator, ICardIterator boardIterator){
        updateCardControllers(boardIterator);
        updateCardDisplay(displayIterator);
        if(displayIterator.hasNext()) {
            this.displayIterator = displayIterator;
        }
    }


    @Override
    public void update(String message) {
            switch (message){
                case "new_level": newLevel();
                break;

                case "game_over": game_over();
                break;

                case "decrement_life" : removeLifeImage();
                break;
            }
    }

    public boolean getNewLevel(){
        return newLevel;
    }

}
