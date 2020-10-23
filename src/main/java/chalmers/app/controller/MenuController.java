/**
 * Author: Nils, Filip, Edenia
 * Responsibility: Load components for scenes and controls the Stage
 * Used by: BoardController, MenuController, App
 * Uses: Game, BoardController, JSONCommunicator
 */
package chalmers.app.controller;

import chalmers.app.model.HighScore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    private MainController mainController;
    private String mode;

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
    @FXML
    FlowPane highscore_flwPane;
    @FXML
    Pane standardModeButton;
    @FXML
    Pane frenzyButton;
    @FXML
    Pane sequenceButton;
    @FXML
    TextField name_textField;
    @FXML
    Text error_text;
    @FXML
    ScrollPane scrollPane;








    public MenuController(MainController mainController) {
        this.mainController = mainController;
        mainController.setMode(mode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillLeaderboard();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }


    /**
     * Fills the flowpane with HighScoreController
     */
    private void fillLeaderboard() {
        highscore_flwPane.getChildren().clear();
        List<HighScore> hList = mainController.getJSONHighScores();

        for(int i = 0; i < hList.size(); i++){
            HighscoreController hc = new HighscoreController(this, String.valueOf(i+1), hList.get(i).getName(),hList.get(i).getMode(),hList.get(i).getScore());
            highscore_flwPane.getChildren().add(hc);
        }

    }

    @FXML
     void startButtonPressed( ) throws Exception{
        modeAnchorPane.toFront();
    }



    @FXML
    private void optionsButtonPressed(){
         soundOptionsPane.toFront();
    }


    @FXML
    void modeStartButtonPressed(){
        if(name_textField.getText().isEmpty()){
            error_text.setText("Enter a name!");
        }else{
            mainController.createGame(mode, name_textField.getText());
            mainController.setBoardScene();
            mainController.saveEnteredName(name_textField.getText());
            error_text.setText("");
        }
    }

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


    @FXML
    void standardModeButtonPressed(){
       setDefaultStyle();
        standardModeButton.getStyleClass().clear();
        standardModeButton.getStyleClass().add("color");
        mode = "standard";
    }

    @FXML
    void frenzyButtonPressed(){
        setDefaultStyle();
        frenzyButton.getStyleClass().clear();
        frenzyButton.getStyleClass().add("color");
        mode = "frenzy";
    }
    @FXML
   void sequenceButtonPressed(){
        setDefaultStyle();
        sequenceButton.getStyleClass().clear();
        sequenceButton.getStyleClass().add("color");
        mode = "sequence";
    }


    private void setDefaultStyle(){
        if(frenzyButton.getStyleClass().contains("color")){
            frenzyButton.getStyleClass().clear();
            frenzyButton.getStyleClass().add("buttonMode");
        }
        if(sequenceButton.getStyleClass().contains("color")){
            sequenceButton.getStyleClass().clear();
            sequenceButton.getStyleClass().add("buttonMode");
        }
        if(standardModeButton.getStyleClass().contains("color")){
            standardModeButton.getStyleClass().clear();
            standardModeButton.getStyleClass().add("buttonMode");
        }
    }

    public void setPlayerName(String name){
        name_textField.setText(name);
    }

}
