package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class A extends SuperObject
{
    public A()
    {
        name = "A";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/A.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
