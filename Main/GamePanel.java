package Main;

import Entity.Player;
import Tile.TileManager;
import WorldObject.SuperObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    BufferedImage image;
    final int originalTileSize = 16; // 16x16 tile - default size of everything - player, letter
    final int scale = 3;

    public final int tileSize = originalTileSize*scale; // 48 px
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol; // 768 px
    public final int screenHeight = tileSize*maxScreenRow; // 576 px


    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;



    int FPS = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();

    Sound music = new Sound();
    Sound soundEffect = new Sound();

    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);

    public UI ui = new UI(this);
    Thread gameThread;

    public Player player = new Player(this, keyHandler);
    public SuperObject obj[] = new SuperObject[21];




    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(4,224,252));

        this.addKeyListener(keyHandler);
        this.setFocusable(true);



    }
    public void setupGame()
    {
        assetSetter.setObject();

    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        // inside run method - we create our game loop.
        double drawInterval = 1000000000/FPS; // 1 second by 60 fps
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread!=null)
        {

            update();
            repaint();

            try
            {
                double remainingTime = nextDrawTime-System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime<0)
                {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }



    }
    public void update()
    {

        player.update();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        // tile
        tileManager.draw(graphics2D);

        // object
        for(int i=0;i<obj.length;i++)
        {
            if(obj[i]!=null)
            {
                obj[i].draw(graphics2D,this);
            }
        }

        // tile should be created before player.

        player.draw(graphics2D);
        ui.draw(graphics2D);
        graphics2D.dispose();
    }

    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();

    }
    public void stopMusic()
    {
        music.stop();

    }
    public void playSoundEffect(int i)
    {
        soundEffect.setFile(i);
        soundEffect.play();
    }

}
