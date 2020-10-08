package chalmers.app.controller;

import chalmers.app.model.Card;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardController implements ISceneController {

    private MainController mainController;
    //private Map<String, CardController> CardMap = new HashMap<String, CardController>();
    private List<CardController> cardControllers = new ArrayList<CardController>();
    File dir = new File("jetbrains://idea/navigate/reference?project=MemoryShape&fqn=view.images.shapes");

    @FXML
    FlowPane flowPane;

    @Override
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void assignImages(String id, CardController cc){
        for(File file: dir.listFiles()){
            String str = new String();
            str.substring(0, str.lastIndexOf(file.getName()));
            if(str == id){
                cc.setImage(file.getPath());
            }
        }

    }

    public void createCards (){
       List<Card> cardList = mainController.game.getBoard().getActiveCardList();
       List< String > IDList = mainController.game.getBoard().getIds();

        for(int i = 0; i < cardList.size(); i ++){
            cardControllers.add( new CardController(this));
            assignImages(IDList.get(i), cardControllers.get(i));
        }
    }

    public void updateBoard(){
        flowPane.getChildren().clear();
        for(CardController cardController: cardControllers){
            flowPane.getChildren().add(cardController);
        }
    }




}
