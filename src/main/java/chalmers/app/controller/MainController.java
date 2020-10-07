package chalmers.app.controller;

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
    SceneSwitcher sceneSwitcher;
    final Stage stage = new Stage();
    Scene menuScene;
    Scene boardScene;

    public MainController(){
        menuScene = initComponents("/view/menu.fxml");
        boardScene = initComponents("/view/board.fxml");
        sceneSwitcher = new SceneSwitcher(stage, menuScene);
    }

    private Scene initComponents(String url) {

        //Load the FXML
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(url));

        // Trying to return scene from FXML url
        // And giving the scene-controller acces to the main-controller
        try {
            Parent parent;
            parent = loader.load();
            ISceneController controller = loader.getController();
            controller.setMainController(this);
            return new Scene(parent);

        } catch (IOException e) {
            System.err.println("Error in initComponent method: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void setMenuScene(){
        sceneSwitcher.setScene(menuScene);
    }

    public void setBoardScene(){
        sceneSwitcher.setScene(boardScene);
    }
}
