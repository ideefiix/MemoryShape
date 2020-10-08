package chalmers.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MenuController implements ISceneController {

    private MainController mainController;

    @FXML
    Pane playButton;
    @FXML
    Pane customButton;
    @FXML
    Pane leaderboardButton;
    @FXML
    Pane optionsButton;
    @FXML
    Pane exitButton;

    //Done from the maincontroller
    @Override
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
     void startButtonPressed() throws Exception{
        mainController.createGame();
        mainController.setBoardScene();
    }

    private void customButtonPressed(){
    }

    private void leaderboardButtonPressed(){
    }

    private void optionsButtonPressed(){
    }

    private void exitButtonPressed(){
    }


}
