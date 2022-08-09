package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class R extends SuperObject
{
    public R()
    {
        name = "R";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/R.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
