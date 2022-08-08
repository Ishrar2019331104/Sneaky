package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Insect extends SuperObject
{
    public Insect()
    {
        name = "Insect";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/insect.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
