package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class P extends SuperObject
{
    public P()
    {
        name = "P";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/P.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
