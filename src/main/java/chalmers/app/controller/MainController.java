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

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/view/board.fxml"));
            loader.setController(new BoardController(this, game));

            Parent parent;
            parent = loader.load();
            stage.setScene(new Scene(parent));

        } catch (IOException e) {
            System.err.println("Error in initComponent method: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createGame() {
        //Hardcoded values for now
        game = new Game(new Player("Nappe", 3), 1);
    }

    public Stage getStage() {
        return stage;
    }

    public void onClick(Card card) {
        cardColorUpdater(card);
        game.boardUpdater();
    }

    public void cardColorUpdater(Card card){

    }
}
