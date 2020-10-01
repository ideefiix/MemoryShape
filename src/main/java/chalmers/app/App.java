package chalmers.app;

import chalmers.app.model.Game;
import chalmers.app.model.Player;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println( "Hello World!!" );

        Game testGame = new Game(new Player("Nappe",3),1);
        testGame.runGame();


    }

}
