/**
 * Authors: Filip
 * Responsibility: Holds data concerning high scores
 * Used by: JSONCommunicator
 * Uses:
 */

package chalmers.app.model;

/**
 * A class used to hold data regarding high scores.
 * Used by the JSONCommunicator class.
 */

public class HighScore {
    private String name, mode;
    private int score;


    public HighScore() {
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
