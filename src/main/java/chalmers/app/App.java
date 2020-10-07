package chalmers.app;

import chalmers.app.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Starts the application
 */
public class App extends Application
{

    @Override
    public void start(Stage stage) throws Exception {

        /*Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        Scene scene = new Scene(root, 1000, 800);

        stage.setTitle("MemoryShape");
        stage.setScene(scene);
        stage.show();*/

        MainController mainController = new MainController();


    }



    public static void main( String[] args ) {
        launch(args);
    }
}
