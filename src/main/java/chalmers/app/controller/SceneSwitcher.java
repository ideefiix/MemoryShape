package chalmers.app.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    /**
     * Author: Filip
     * Responsibility: Scene manipulation
     * Used by: MainController
     */

    private final Stage stage;

    public SceneSwitcher(Stage stage, Scene startingScene) {
        this.stage = stage;
        onStartup(startingScene);
    }

    /**
     * Shows the menu scene
     * @param startingScene
     */
    private void onStartup(Scene startingScene){
        stage.setMinWidth(1000);
        stage.setMinHeight(800);
        stage.setTitle("MemoryShape");
        stage.setScene(startingScene);
        stage.show();
    }

    public void setScene(Scene scene){
        stage.setScene(scene);
    }

}
