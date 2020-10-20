package chalmers.app.controller;

import chalmers.app.model.Card;
import chalmers.app.model.Game;
import chalmers.app.model.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Author: Filip
 * Responsibility: Load components for scenes and control the Stage
 */
public class MainController {

    final Stage stage = new Stage();
    Game game;

    public MainController(){
        setMenuScene();
    }


    public void setMenuScene(){

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
            loader.setController(new MenuController(this));

            Parent parent;
            parent = loader.load();
            stage.setScene(new Scene(parent));

        } catch (IOException e) {
            System.err.println("Error in initComponent method: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setBoardScene(){
        createGame();
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
            Thread.sleep(4000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
    public void createGame() {
        //Hardcoded values for now
        game = new Game(new Player("Nappe",3), Game.GameMode.STANDARD); //borde inte ha koppling till player
    }



    public Stage getStage() {
        return stage;
    }

    public void onClick(Card card) {
        game.onClick(card);
    }

    public void cardColorUpdater(Card card){

    }

}
