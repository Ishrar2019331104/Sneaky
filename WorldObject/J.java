package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class J extends SuperObject
{
    public J()
    {
        name = "J";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/J.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
