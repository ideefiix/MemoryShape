package chalmers.app.model;

public class Highscore {
    private String name,mode,score;

    public Highscore(String name, String mode, String score) {
        this.name = name;
        this.mode = mode;
        this.score = score;
    }
    public Highscore() {
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public String getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
