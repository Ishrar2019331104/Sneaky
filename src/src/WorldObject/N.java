package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class N extends SuperObject
{
    public N()
    {
        name = "N";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/N.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
