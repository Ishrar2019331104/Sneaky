package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound
{
    Clip clip;
    URL soundURL[] = new URL[30];

    /**
     * keeps all sounds on arrays of type URL
     */
    public Sound()
    {
        soundURL[0] = getClass().getResource("/CLOUD.wav");
        soundURL[1] = getClass().getResource("/insect.wav");
        soundURL[2] = getClass().getResource("/collision_with_tree.wav");
        soundURL[3] = getClass().getResource("/acid_other_letters.wav");
        soundURL[4] = getClass().getResource("/Game Over (8-Bit Music).wav");
        soundURL[5] = getClass().getResource("/intro.wav");
        soundURL[6] = getClass().getResource("/winning.wav");

    }

    /**
     * loads the sound files
     * @param i - based on indexes of URL array.
     */
    public void setFile(int i)
    {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);


        }
        catch (Exception e)
        {

        }
    }

    /**
     * starts the sound clip
     */
    public void play()
    {
        clip.start();
    }

    /**
     * method to play the sound in loop.
     */
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * method to stop the sound.
     */
    public void stop()
    {
        clip.stop();
    }

}
