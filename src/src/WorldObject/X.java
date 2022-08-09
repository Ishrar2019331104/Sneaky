package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class X extends SuperObject
{
    public X()
    {
        name = "X";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/X.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
