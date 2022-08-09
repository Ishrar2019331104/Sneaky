package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Z extends SuperObject
{
    public Z()
    {
        name = "Z";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Z.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
