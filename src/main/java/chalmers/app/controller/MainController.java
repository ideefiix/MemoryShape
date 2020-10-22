/**
 * Author: Filip
 * Responsibility: Load components for scenes and controls the Stage
 * Used by: BoardController, MenuController, App
 * Uses: Game, BoardController, JSONCommunicator
 */
package chalmers.app.controller;

import chalmers.app.model.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class MainController {

    final Stage stage = new Stage();
    private JSONCommunicator jCom = new JSONCommunicator();
    private MusicPlayer mp = new MusicPlayer();
    String enterName = null;
    String mode;
    String playerName;
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
        this.playerName = playerName;
        this.mode = mode;
        switch (mode){
            case "standard": game = new Game(playerName, Game.GameMode.STANDARD);
            break;
            case "frenzy": game = new Game(playerName, Game.GameMode.FRENZY);
            break;
            case "sequence": game = new Game(playerName, Game.GameMode.SIMONSAYS);
            break;
        }

    }


    public void newGame() {
        switch (mode) {
            case "standard":
                game = new Game(playerName, Game.GameMode.STANDARD);
                break;
            case "frenzy":
                game = new Game(playerName, Game.GameMode.FRENZY);
                break;
            case "sequence":
                game = new Game(playerName, Game.GameMode.SIMONSAYS);
                break;
        }
    }


    public Stage getStage() {
        return stage;
    }


    public void onClick(ICard card) {
        mp.playOnClickSound();
        game.onClick(card);
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
        jCom.compareScore(game.getCurrentScore(),mode,game.getName()); //Brukade vara game.getModeString() ist för mode. kanske orsakar nått
    }

    public void saveEnteredName(String enteredName){
        enterName = enteredName;
    }

    public void setMode(String mode){
        this.mode = mode;
    }
}
