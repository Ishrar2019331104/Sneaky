package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class K extends SuperObject
{
    public K()
    {
        name = "K";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/K.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
