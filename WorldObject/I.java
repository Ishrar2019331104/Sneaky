package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class I extends SuperObject
{
    public I()
    {
        name = "I";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/I.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
