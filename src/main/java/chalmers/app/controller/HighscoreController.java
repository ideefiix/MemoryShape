package chalmers.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HighscoreController extends AnchorPane {
    private MenuController parentController;

    @FXML
    Label position;
    @FXML
    Label name;
    @FXML
    Label mode;
    @FXML
    Label score;

    public HighscoreController(MenuController parentController, String position, String name, String mode, String score) {
        this.parentController = parentController;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/highscore.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.position.setText(position);
        this.name.setText(name);
        this.mode.setText(mode);
        this.score.setText(score);
    }
}
