package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class G extends SuperObject
{
    public G()
    {
        name = "G";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/G.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
