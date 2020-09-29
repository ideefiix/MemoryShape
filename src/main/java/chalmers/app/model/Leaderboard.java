package chalmers.app.model;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private List<FinishedRun> finishedRuns;





    private class FinishedRun{
        private int time;
        private int healthLeft;
        private int score;
        private String date;
    }


    private void updateRuns(){

    }

    /**
     * Uppdaterar Leaderboarden efter att ett spel avslutats
     * @param score Resultatet från den förlorade rundan
     * @param highScores Dem sparade highscorsen i textfilen
     */

    // TODO fixa textfil med Highscores
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
