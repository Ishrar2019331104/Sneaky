package WorldObject;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Heart extends SuperObject
{
    GamePanel gamePanel;

    /**
     * constructor for loading Heart Images
     * @param gamePanel - accepts gamePanel
     */
    public Heart(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
        name = "Heart";
        try
        {
            image1 = ImageIO.read(getClass().getResourceAsStream("/fullheart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/blankheart.png"));


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
