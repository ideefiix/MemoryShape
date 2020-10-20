package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.CardEnums.CardState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;


public class CardController extends AnchorPane  {
    private BoardController parentController;
    Card card;

    @FXML
    ImageView image;
    @FXML
    AnchorPane backgroundPane;


    public CardController(BoardController parentController, Card card) {
        this.parentController = parentController;
        this.card = card;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/card.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {

            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void setImage(File file){

        Image imageFromUrl = new Image(file.toURI().toString());
        image.setImage(imageFromUrl);

    }

    public void setImage(Image i){
        image.setImage(i);
    }

    public void hideImage(){
        image.setVisible(false);
    }

    public void showImage(){
        image.setVisible(true);
    }


    @FXML
    public void onClick(){
        if(card.getState() != CardState.INCORRECT && card.getState() != CardState.CORRECT && !parentController.newLevel){
            parentController.onclick(card);
        }
    }

    public void setCard(Card card){
        this.card = card;
    }

    public void updateCardState(){
        backgroundPane.getStyleClass().clear();
        showImage();
        switch (card.getState()){
            case INCORRECT:
                backgroundPane.getStyleClass().add("card_Red");
                break;
            case CORRECT:
                backgroundPane.getStyleClass().add("card_Green");
                break;
            case FACEUP:
                backgroundPane.getStyleClass().add("card_Default");
                break;
            case FACEDOWN:
                backgroundPane.getStyleClass().add("card_Default");
                hideImage();
                break;

        }
    }


    public AnchorPane getBackgroundPane() {
        return backgroundPane;
    }
    public Card getCard() {
        return card;
    }

    public void setNoPliancy(){
        backgroundPane.getStyleClass().clear();
        backgroundPane.getStyleClass().add("card_NoPliancy");
    }

    public void setBackPliancy(){
        backgroundPane.getStyleClass().clear();
        backgroundPane.getStyleClass().add("card_Default");
    }
}

