package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class E extends SuperObject
{
    public E()
    {
        name = "E";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/E.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
