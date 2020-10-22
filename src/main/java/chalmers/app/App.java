package chalmers.app;

import chalmers.app.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starts the application
 */
public class App extends Application
{

    @Override
    public void start(Stage stage) throws Exception {

        final MainController mainController = new MainController();
        mainController.getStage().show();
        mainController.getStage().setTitle("MemoryShape");


        /**
         * Added a shutdown hook so data can be saved to JSON file on shutdown
         */
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
               // mainController.getJSONCommunicator().writeHighscores();
                System.out.println("Is shuting down");
            }
        }, "Shutdown-thread"));
    }



    public static void main( String[] args ) {
        launch(args);
    }
}
