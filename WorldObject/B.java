package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class B extends SuperObject
{
    public B()
    {
        name = "B";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/B.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
