package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class M extends SuperObject
{
    public M()
    {
        name = "M";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/M.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
