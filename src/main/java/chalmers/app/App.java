/**
 * Authors: Filip
 * Class used to start the application.
 */
package chalmers.app;

import chalmers.app.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    /**
     * Starts the application.
     * Uses a shutdown hook so data can be saved to JSON file on shutdown.
     */
    @Override
    public void start(Stage stage) throws Exception {

        final MainController mainController = new MainController();
        mainController.getStage().show();
        mainController.getStage().setTitle("MemoryShape");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                mainController.getJSONCommunicator().writeHighscores();
                System.out.println("Is shutting down");
            }
        }, "Shutdown-thread"));
    }

    public static void main( String[] args ) {
        launch(args);
    }
}
