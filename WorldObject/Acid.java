package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Acid extends SuperObject
{
    public Acid()
    {
        name = "Acid";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/acid.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
