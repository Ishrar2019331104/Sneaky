package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class T extends SuperObject
{
    public T()
    {
        name = "T";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/T.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
