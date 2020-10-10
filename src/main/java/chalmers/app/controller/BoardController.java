package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

    private MainController mainController;
    private Game game;
    private List<CardController> cardControllers = new ArrayList<CardController>();
    File dir = new File("src/main/resources/view/images/shapes");




    @FXML
    FlowPane flowPane;
    @FXML
    ImageView selectedCard;

    public BoardController(MainController mainController, Game game) {
        this.mainController = mainController;
        this.game = game;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCards();
        updateBoard();
        setSelectedCard();
        hideCards();
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
     * Sets the image for selectedcard
     */
    public void setSelectedCard(){
        Card selected = game.getCardSelector().getSelectedCard();
        assignImageCardSelector(selected.getID());

    }

    /**
     * Is called by ↑
     */

    public void assignImageCardSelector(String id){
        for(File file: dir.listFiles()){

            //Remove .JPG extension
            String str = file.getName();
            int pos = str.lastIndexOf(".");

            if(str.substring(0,pos).equals(id)){
                selectedCard.setImage(new Image(file.toURI().toString()));
                break;
            }
        }

    }

    /**
     * Makes the cardshapes invincible
     */

    public void hideCards(){
        for(CardController cc: cardControllers){
            cc.hideImage();
        }

    }

    public Game getGame() {
        return game;
    }

    public void incScore(){
        game.getPlayer().incScore();
    }

    public void bcDecLife(){
        game.getPlayer().decLife();
    }

    public void isLevelCompleted(){
        if(game.getCardSelector().isBoardCleared()){
            game.incLevel();
            game.newBoard();

            cardControllers = new ArrayList<>();
            createCards();
            updateBoard();
            setSelectedCard();
            hideCards();

        }
    }
}
