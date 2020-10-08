package chalmers.app.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CardController extends AnchorPane {
    private BoardController parentController;

    @FXML
    ImageView image;

    public void setImage(String url){

        image.setImage(new Image(url));
    }

    public CardController(BoardController parentController) {
        this.parentController = parentController;
    }
}
