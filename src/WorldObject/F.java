package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class F extends SuperObject
{
    public F()
    {
        name = "F";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/F.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
