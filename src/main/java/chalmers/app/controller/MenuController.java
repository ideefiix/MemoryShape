package chalmers.app.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class MenuController {

    private MainController mainController;

    @FXML
    AnchorPane menuAnchorPane;
    @FXML
    AnchorPane leaderboardAnchorPane;
    @FXML
    AnchorPane playerNameAnchorPane;
    @FXML
    AnchorPane modeAnchorPane;
    @FXML
    AnchorPane soundOptionsPane;





    public MenuController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
     void startButtonPressed( ) throws Exception{ //
        mainController.createGame();
        modeAnchorPane.toFront();

    }



    @FXML
    private void optionsButtonPressed(){ //
         soundOptionsPane.toFront();
    }


    @FXML
    void modeStartButtonPressed(){
        mainController.setBoardScene();
    } //

    @FXML
    void leaderboardButtonPressed(){ //
        leaderboardAnchorPane.toFront();
    }

    @FXML
    private void exitButtonPressed(){
        mainController.getStage().close();
    }


    @FXML
    void  backButtonPressed(){
        menuAnchorPane.toFront();
    }


    @FXML
    void newPlayerButtonPressed(){
        playerNameAnchorPane.toFront();
    }



}
