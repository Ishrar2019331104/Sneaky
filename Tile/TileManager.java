package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gamePanel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp)
    {
        gamePanel = gp;
        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("/worldmap.txt");
    }
    public void getTileImage()
    {
        try
        {
           tile[0] = new Tile();
           tile[0].image = ImageIO.read(getClass().getResourceAsStream("/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/sand.png"));


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * loads worldMap from output.txt file.
     * @param filePath
     */
    public void loadMap(String filePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col<gamePanel.maxWorldCol && row<gamePanel.maxWorldRow)
            {
                String line = bufferedReader.readLine();
                while(col< gamePanel.maxWorldCol)
                {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col==gamePanel.maxWorldCol)
                {
                    col = 0;
                    row++;
                }

            }
            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * draws the map in a 50x50 space.
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D)
    {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol<gamePanel.maxWorldCol && worldRow<gamePanel.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol*gamePanel.tileSize;
            int worldY = worldRow*gamePanel.tileSize;
            int screenX = worldX-gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY-gamePanel.player.worldY + gamePanel.player.screenY;
            if(worldX + gamePanel.tileSize >gamePanel.player.worldX - gamePanel.player.screenX &&
             worldX - gamePanel.tileSize <gamePanel.player.worldX + gamePanel.player.screenX
            && worldY + gamePanel.tileSize>gamePanel.player.worldY - gamePanel.player.screenY &&
            worldY - gamePanel.tileSize<gamePanel.player.worldY + gamePanel.player.screenY)
            {
                graphics2D.drawImage(tile[tileNum].image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize,null);

            }
            worldCol++;

            if(worldCol==gamePanel.maxWorldCol)
            {
                worldCol = 0;

                worldRow++;

            }
        }
    }
}
