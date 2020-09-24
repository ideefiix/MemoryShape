package chalmers.app.model;


public class Player {
    String name;
    int currentScore;
    int[] highScores;
    int lives;

    public Player(String name, int lives) {
        this.name = name;
        this.currentScore = 0;
        this.highScores = new int[10];
        this.lives = lives;
    }

    /**
    *Anropas varje gång spelaren väljer rätt kort
     */
    void incScore(){
        currentScore++;
    }

    /**
     * Anropas varje gång spelaren väljer fel kort
     */
    void lifeLost(){
        lives--;
        if(lives<1){
            gameOver(currentScore, highScores);
            currentScore = 0;
        }
    }

    /**
     * Visar game over vyn och anropar metoden som uppdaterar leaderboarden
     * OBS! Parametrarna är ej nödvändiga så länge metoden ligger i den här klassen. De lades till i förebyggande syfte
     * @param score Resultatet från den förlorade rundan
     * @param highScores Spelarens bästa resultat hittills
     */
    void gameOver(int score, int[] highScores){
        //visa game over vyn
        updateLeaderboard(score, highScores);
    }

    /**
     * Uppdaterar Leaderboarden efter att ett spel avslutats
     * OBS! Parametrarna är ej nödvändiga så länge metoden ligger i den här klassen. De lades till i förebyggande syfte
     * @param score Resultatet från den förlorade rundan
     * @param highScores Spelarens bästa resultat hittills
     */
    void updateLeaderboard(int score, int[]highScores){
        int temp;
        if(score > highScores[9]){
            highScores[9] = score;
            for(int i = 8; i >= 0; i--) {
                if(highScores[i+1] > highScores[i]){
                    temp = highScores[i];
                    highScores[i] = highScores[i+1];
                    highScores[i+1] = temp;
                }
                else break;
            }
        }
    }
}
