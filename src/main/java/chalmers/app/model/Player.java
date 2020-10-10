package chalmers.app.model;


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
    *Anropas varje gång spelaren väljer rätt kort
     */
    public void incScore(){
        currentScore++;
    }

    /**
     * Anropas varje gång spelaren väljer fel kort
     */
    public void decLife(){
        lives--;
    }

    public boolean IsAlive(){
        if(lives<1){
            currentScore = 0;
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

    public int getLives() {
        return lives;
    }
}
