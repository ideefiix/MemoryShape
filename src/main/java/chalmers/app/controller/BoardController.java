package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;

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

    public BoardController(MainController mainController, Game game) {
        this.mainController = mainController;
        this.game = game;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCards();
        updateBoard();
    }

    public void createCards (){
        List<Card> cardList = game.getBoard().getActiveCardList();
        List< String > IDList = game.getBoard().getIds();

        for(int i = 0; i < cardList.size(); i ++){
            cardControllers.add( new CardController(this));
            assignImages(IDList.get(i), cardControllers.get(i));
        }
    }

    public void assignImages(String id, CardController cc){
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

    public void updateBoard(){
        flowPane.getChildren().clear();
        for(CardController cardController: cardControllers){
            flowPane.getChildren().add(cardController);
        }
    }

}
