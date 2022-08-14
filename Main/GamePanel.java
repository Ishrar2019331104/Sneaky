package Main;

import Entity.Player;
import Tile.TileManager;
import WorldObject.SuperObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable
{
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
    KeyHandler keyHandler = new KeyHandler(this);
    MouseHandler mouseHandler = new MouseHandler(this);

    Sound music = new Sound();
    Sound soundEffect = new Sound();

    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);

    public UI ui = new UI(this);
    Thread gameThread;

    public Player player = new Player(this, keyHandler,mouseHandler);
    public SuperObject obj[] = new SuperObject[30];

    // GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int titleState = 0;
    public final int gameOverState = 3;
    public final int winState = 4;




    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(4,224,252));
        this.addMouseListener(mouseHandler);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);




    }

    /**
     * loads the tiles and title screen after game loop starts.
     */
    public void setupGame()
    {
        assetSetter.setObject();
        gameState = titleState;

    }

    /**
     * Starts the game thread.
     */
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
//    public void retry()
//    {
//        player.setDefaultPositions();
//        player.restoreLife();
//    }
//    public void restart()
//    {
//        ui.drawScreen();
//        player.setDefaultValues();
//        player.setDefaultPositions();
//        assetSetter.setObject();
//
//
//    }
    /**
     * Implements the thread by using System time to control loop. loop->update->loop->repaint->update->loop->
     */
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
    /**
     * updates the playState using system time and does nothing if in pauseState
     */
    public void update()
    {
        if(gameState==playState)
        {
            player.update();

        }
        if(gameState==pauseState)
        {

        }


    }

    /**
     * main base for drawing different components of the UI
     * @param g - used to draw in GUI
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        // title state
        if(gameState == titleState)
        {
            ui.draw(graphics2D);
        }
        // others
        // tile

        else {
            tileManager.draw(graphics2D);


            // object
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(graphics2D, this);
                }
            }

            // tile should be created before player.

            player.draw(graphics2D);
            ui.draw(graphics2D);
            graphics2D.dispose();
        }
    }

    /**
     * Plays music
     * @param i - based on this number, the method selects which music to play.
     */
    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();


    }
    /**
     * called to stop music.
     */
    public void stopMusic()
    {
        music.stop();

    }

    /**
     * plays sound effects
     * @param i - based on this number, the method selects which sound effect to play.
     */
    public void playSoundEffect(int i)
    {
        soundEffect.setFile(i);
        soundEffect.play();
    }

}
