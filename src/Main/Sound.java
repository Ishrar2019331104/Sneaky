package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound
{
    Clip clip;
    URL soundURL[] = new URL[30];
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
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }

}
