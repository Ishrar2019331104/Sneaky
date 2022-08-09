package WorldObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import Main.GamePanel;

public class SuperObject
{
    public BufferedImage image;
    public BufferedImage image1, image2;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    /**
     * Determines location of object with respect to worldmap , draws the objects on the screen.
     * @param graphics2D accepts graphics2D
     * @param gamePanel accepts gamePanel
     */
    public void draw(Graphics2D graphics2D, GamePanel gamePanel)
    {
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
        if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY)
        {
            graphics2D.drawImage(image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize,null);
        }
    }

}
