/**
 * Authors: Filip
 * Responsibility: Communicate with JSON file
 * Used by: MainController
 * Uses: HighScores
 */
package chalmers.app.controller;

import chalmers.app.model.HighScore;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONCommunicator {
    private List<HighScore> hList = new ArrayList<>();

    public JSONCommunicator() {
        loadHighscores();
    }

    /**
     * On startup
     * Load 10 Highscores from JSON file
     **/


    public void loadHighscores(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/highscores.json"));
            hList = mapper.readValue(inputStream, new TypeReference<List<HighScore>>() {});

            inputStream.close();

        } catch (FileNotFoundException e){

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * On shutdown
     * Writes the highScores to JSON file
     */
    public void writeHighscores() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/highscores.json"));
            mapper.writeValue(new File("src/main/resources/highscores.json"), hList);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
                e.printStackTrace();
            }

    }

    public List<HighScore> gethList() {
        return hList;
    }

    /**
     * Adds a score to Highscore-list if it's high enough
     */

    public void compareScore(int currentScore, String mode, String name) {

        HighScore temp = new HighScore();
        temp.setName(name);
        temp.setMode(mode);
        temp.setScore(currentScore);

        if (temp.getScore() > hList.get(9).getScore()) {
            hList.get(9).setScore(temp.getScore());
            hList.get(9).setMode(temp.getMode());
            hList.get(9).setName(temp.getName());

            for (int i = 9; i > 0; i--) {
                

                if (hList.get(i).getScore() > hList.get(i - 1).getScore()) {

                    temp.setName(hList.get(i-1).getName());
                    temp.setMode(hList.get(i-1).getMode());
                    temp.setScore(hList.get(i-1).getScore());
                    // Ex: 9 -> 8
                    hList.get(i-1).setScore(hList.get(i).getScore());
                    hList.get(i-1).setMode(hList.get(i).getMode());
                    hList.get(i-1).setName(hList.get(i).getName());
                    // Ex: 8 -> 9
                    hList.get(i).setScore(temp.getScore());
                    hList.get(i).setMode(temp.getMode());
                    hList.get(i).setName(temp.getName());

                } else {
                    break;
                }

            }

        }
    }
}
