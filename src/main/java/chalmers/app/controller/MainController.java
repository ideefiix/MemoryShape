package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import chalmers.app.model.Highscore;
import chalmers.app.model.Player;
import com.sun.glass.ui.Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Author: Filip
 * Responsibility: Load components for scenes and control the Stage
 */
public class MainController {

    final Stage stage = new Stage();
    private JSONCommunicator jCom = new JSONCommunicator();
    private MusicPlayer mp = new MusicPlayer();
    String enterName = null;
    Game game;

    public MainController(){
        setMenuScene();
        //mp.playBackgroundMusic();
    }


    public void setMenuScene(){

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
            MenuController mc = new MenuController(this);

            loader.setController(mc);

            Parent parent;
            parent = loader.load();
            stage.setScene(new Scene(parent));

            //Autofill textbox with player name
            if(enterName != null){
                mc.setPlayerName(enterName);
            }

        } catch (IOException e) {
            System.err.println("Error in initComponent method: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setBoardScene(){
        //createGame(mode);
        //BoardController BC = new BoardController(this,game, game.getCardDisplay2().getCardList());
        //game.setGameObserver(BC);

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/view/board.fxml"));

            BoardController bC = new BoardController(this);
            loader.setController(bC);
            game.setGameObserver(bC);



            Parent parent;
            parent = loader.load();
            stage.setScene(new Scene(parent));
            game.setUpObserver();


        } catch (IOException e) {
            System.err.println("Error in initComponent method: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void delay(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    public void createGame(String mode, String playerName) {
        switch (mode){
            case "standard": game = new Game(playerName, Game.GameMode.STANDARD);
            break;
            case "frenzy": game = new Game(playerName, Game.GameMode.FRENZY);
            break;
            case "sequence": game = new Game(playerName, Game.GameMode.SIMONSAYS);
            break;
        }

    }



    public Stage getStage() {
        return stage;
    }

    public void onClick(Card card) {
        mp.playOnClickSound();
        game.onClick(card);
    }

    public void cardColorUpdater(Card card){

    }

    public int getLevel(){
        return game.getLevel();
    }

    public Player getPlayer(){
        return game.getPlayer();
    }

    public List<Highscore> getJSONHighscores(){
        return jCom.gethList();
    }

    public JSONCommunicator getJSONCommunicator(){
        return jCom;
    }

    public void sendnewScore() {
        jCom.compareScore(game.getCurrentScore(),game.getModeString(),game.getName());
    }

    public void saveEnteredName(String enteredName){
        enterName = enteredName;
    }
}
