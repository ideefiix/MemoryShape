package chalmers.app.controller;

import chalmers.app.model.Card;
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
        showImage();
        String rightID = parentController.getGame().getCardSelector().getSelectedCard().getID();
        if(card.getID().equals(rightID)){
            backgroundPane.setStyle("-fx-background-color: #" + "73ba70");
            parentController.incScore();
            parentController.getGame().getCardSelector().changeSelectedCard();
            parentController.setSelectedCard();

            // Will create a new board if the board is completed
            parentController.isLevelCompleted();
        }
        else{
            backgroundPane.setStyle("-fx-background-color: #" + "c75a5a");
            parentController.bcDecLife();

            Thread thread = new Thread(){
                public void run(){
                    try{
                        Thread.sleep(5000);
                        hideImage();
                        backgroundPane.setStyle("-fx-background-color: #" + "ffffff");
                    }catch (Exception e){

                    }
                }
            };
            thread.start();
        }

    }


}

