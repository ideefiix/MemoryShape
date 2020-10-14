package chalmers.app.controller;

import chalmers.app.model.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        parentController.onclick(card);
    }

}

