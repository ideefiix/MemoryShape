package chalmers.app.controller;

import chalmers.app.model.Highscore;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    private MainController mainController;
    private List<Highscore> hList;

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





    public MenuController(MainController mainController) {
        this.mainController = mainController;
        loadHighscores();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fill_leaderboard();
    }

    /**
     * Load 10 Highscores from JSON file
     */

    void loadHighscores(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/highscores.json"));
            hList = mapper.readValue(inputStream, new TypeReference<List<Highscore>>() {});
            for(int i = 0; i < hList.size(); i++){
                System.out.println(hList.get(i).getName());
            }

            inputStream.close();

        } catch (FileNotFoundException e){

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fills the flowpane with HighScoreController
     */
    private void fill_leaderboard() {
        highscore_flwPane.getChildren().clear();

        for(int i = 0; i < hList.size(); i++){
            HighscoreController hc = new HighscoreController(this, String.valueOf(i+1), hList.get(i).getName(),hList.get(i).getMode(),hList.get(i).getScore());
            highscore_flwPane.getChildren().add(hc);
        }

    }

    /**
     * TODO Called when program is shut down
     * Writes the highScores to JSON file
     */
    void writeHighscores() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/highscores.json"));
            mapper.writeValue(new File("src/main/resources/highscores.json"), hList);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
                e.printStackTrace();
            }

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
