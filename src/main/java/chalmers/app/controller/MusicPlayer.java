package chalmers.app.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class MusicPlayer {

    /**
     * Author: Filip
     * IS not implemented yet
     */

    public void playBackgroundMusic (){
        try {
            InputStream music = new FileInputStream(new File("FILEPATH"));
            AudioInputStream audios = AudioSystem.getAudioInputStream(music);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playOnClickSound(){

    }
}
