package chalmers.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardController extends AnchorPane  {
    private BoardController parentController;

    @FXML
    ImageView image;

    public void setImage(File file){

        Image imageFromUrl = new Image(file.toURI().toString());
        image.setImage(imageFromUrl);

    }

    public CardController(BoardController parentController) {
        this.parentController = parentController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/card.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {

            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }


}
