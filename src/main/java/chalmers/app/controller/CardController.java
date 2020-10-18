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

    public void hideImage(){
        image.setVisible(false);
    }

    public void showImage(){
        image.setVisible(true);
    }


    @FXML
    public void onClick(){
        // You can't click on removed cards
        if(card.getisRemoved() == false){
            parentController.onclick(card);


            // Hide the previosly wrong guess
            for(CardController cc: parentController.getCardControllers()){
                if (cc.getCard().getFlipped() && cc.getCard().getisRemoved() == false){
                    cc.hideImage();
                    cc.getBackgroundPane().getStyleClass().clear();
                    cc.getBackgroundPane().getStyleClass().add("card_Default");
                }
            }
            card.setFlipped(true);

            //Manipulate the clicked card
            if(card.getisRemoved()){
                backgroundPane.getStyleClass().clear();
                backgroundPane.getStyleClass().add("card_Green");
            }else{
                backgroundPane.getStyleClass().clear();
                backgroundPane.getStyleClass().add("card_Red");
            }

            showImage();

            //Update Selectedcard if right
            if(card.getisRemoved()){
                parentController.setNextDisplayImage();
            }
        }
        //Is game over?
        parentController.isBoardCleared();
    }

    public void onClick2(){
        if(card.getState() != CardState.INCORRECT && card.getState() != CardState.CORRECT){
            parentController.onclick(card);
        }
    }

    public void setCard(Card card){
        this.card = card;
    }

    public void updateCardState(){
        backgroundPane.getStyleClass().clear();
        switch (card.getState()){
            case INCORRECT:{
                backgroundPane.getStyleClass().add("card_Green");
            }
            case CORRECT:{
                backgroundPane.getStyleClass().add("card_Red");
            }
            case FACEUP:{
                backgroundPane.getStyleClass().add("card_Default");
            }
            case FACEDOWN:{
                backgroundPane.getStyleClass().add("card_Default");
                hideImage();
            }
        }
    }


    public AnchorPane getBackgroundPane() {
        return backgroundPane;
    }
    public Card getCard() {
        return card;
    }
}

