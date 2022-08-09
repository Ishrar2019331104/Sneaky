package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class H extends SuperObject
{
    public H()
    {
        name = "H";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/H.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
