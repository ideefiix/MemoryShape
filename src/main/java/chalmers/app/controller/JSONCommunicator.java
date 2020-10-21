package chalmers.app.controller;

import chalmers.app.model.Highscore;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONCommunicator {
    private List<Highscore> hList = new ArrayList<>();

    public JSONCommunicator() {
        loadHighscores();
    }

    /**
 * On startup
 * Load 10 Highscores from JSON file
 */

    public void loadHighscores(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/highscores.json"));
            hList = mapper.readValue(inputStream, new TypeReference<List<Highscore>>() {});
            for(int i = 0; i < hList.size(); i++){
                System.out.println(hList.get(i).getName());
            }

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

    public List<Highscore> gethList() {
        return hList;
    }

    public void sethList(List<Highscore> hList) {
        this.hList = hList;
    }

    /**
     * Adds a score to Highscore-list if it's high enough
     */

    public void compareScore(int currentScore, String mode, String name) {

        int index = -1;

        for (int i = 9; i >= 0; i--){
            if (currentScore > hList.get(i).getScore()){
                index = i;
            } else{
                break;
            }
        }
        /**
         * Check if card made it to Highscorelist
         */
        if(index != -1){
            hList.get(index).setScore(currentScore);
            hList.get(index).setMode(mode);
            hList.get(index).setName(name);
        }
    }
}
