package chalmers.app.model;

/**
 * A class holding data about the player of the game
 */
public class Player {

    String name;
    int currentScore;
    int lives;


    public Player(String name, int lives) {
        this.name = name;
        this.currentScore = 0;
        this.lives = lives;
    }


    /**
     * Increases the player's score
     */
    public void incScore(){
        currentScore++;
    }


    /**
     * Decreases the players number of lives.
     */
    public void decLife(){
        lives--;
    }


    /**
     * Returns true if the player has one life or more.
     */
    public boolean IsAlive(){
        if(lives<1){
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

}
