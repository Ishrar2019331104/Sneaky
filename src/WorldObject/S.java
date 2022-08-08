package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class S extends SuperObject
{
    public S()
    {
        name = "S";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/S.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
