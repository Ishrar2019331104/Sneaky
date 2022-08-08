package Main;

import WorldObject.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

// handles on screen UI
public class UI {
    GamePanel gamePanel;
    Font arial_40;
    Font minecraft;
    public int commandNumber = 0;
    BufferedImage block1, block2, block3, block4, block5;
    BufferedImage letter1, letter2, letter3, letter4, letter5;
    BufferedImage heartFull1, heartFull2, heartFull3, heartBlank1, heartBlank2, heartBlank3;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    Graphics2D graphics2D;
    public boolean gameFinished = false;
    public boolean gameOver = false;
    public UI(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Underscore underscore = new Underscore();
        C c = new C();
        L l = new L();
        O o = new O();
        U u = new U();
        D d = new D();
        Heart heart = new Heart(gamePanel);

        letter1 = c.image;
        letter2 = l.image;
        letter3 = o.image;
        letter4 = u.image;
        letter5 = d.image;
        block1 = underscore.image;
        block2 = underscore.image;
        block3 = underscore.image;
        block4 = underscore.image;
        block5 = underscore.image;
        heartFull1 = heart.image1;
        heartFull2 = heart.image1;
        heartFull3 = heart.image1;
        heartBlank1 = heart.image2;
        heartBlank2 = heart.image2;
        heartBlank3 = heart.image2;



    }
    public void draw(Graphics2D graphics2D)  {

        if(gameFinished==true)
        {
            graphics2D.setFont(arial_40);
            graphics2D.setColor(Color.white);

            String text;
            int textLength;
            int x, y;

            text = "You've got CLOUD!";
            textLength = (int)graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
            x = gamePanel.screenWidth/2 - textLength/2;
            y = gamePanel.screenHeight/2 - (gamePanel.tileSize*3);

            graphics2D.drawString(text,x,y);
            gamePanel.gameThread = null;
        }
        else if(gameOver==true)
        {
            graphics2D.setFont(arial_40);
            graphics2D.setColor(Color.white);

            String text;
            int textLength;
            int x, y;

            text = "Game over!";
            textLength = (int)graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
            x = gamePanel.screenWidth/2 - textLength/2;
            y = gamePanel.screenHeight/2 - (gamePanel.tileSize*3);

            graphics2D.drawString(text,x,y);
            gamePanel.gameThread = null;
        }
        else if (gamePanel.gameState== gamePanel.playState)
        {
            graphics2D.setFont(arial_40);
            graphics2D.setColor(Color.white);
            graphics2D.drawImage(block1, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block2, gamePanel.tileSize / 2 + 48, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block3, gamePanel.tileSize / 2 + 96, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block4, gamePanel.tileSize / 2 + 144, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block5, gamePanel.tileSize / 2 + 192, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(heartFull1, gamePanel.tileSize / 2 + 528, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);
            graphics2D.drawImage(heartFull2, gamePanel.tileSize / 2 + 576, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);
            graphics2D.drawImage(heartFull3, gamePanel.tileSize / 2 + 624, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);

            if (gamePanel.player.hasC > 0) {
                block1 = null;
                graphics2D.drawImage(letter1, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasL > 0) {
                block2 = null;
                graphics2D.drawImage(letter2, gamePanel.tileSize / 2 + 48, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasO > 0) {
                block3 = null;
                graphics2D.drawImage(letter3, gamePanel.tileSize / 2 + 96, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasU > 0) {
                block4 = null;
                graphics2D.drawImage(letter4, gamePanel.tileSize / 2 + 144, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasD > 0) {
                block5 = null;
                graphics2D.drawImage(letter5, gamePanel.tileSize / 2 + 192, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if(gamePanel.player.life==2)
            {
                heartFull3 = null;
                graphics2D.drawImage(heartBlank3, gamePanel.tileSize / 2 + 624, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);


            }
            if(gamePanel.player.life==1)
            {
                heartFull2 = null;
                graphics2D.drawImage(heartBlank3, gamePanel.tileSize / 2 + 624, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);
                graphics2D.drawImage(heartBlank2, gamePanel.tileSize / 2 + 576, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize,null);

            }
        }
        this.graphics2D = graphics2D;

        try{
            InputStream is = getClass().getResourceAsStream("/Minecraft.ttf");
            minecraft = Font.createFont(Font.TRUETYPE_FONT,is);
        }
        catch (FontFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        graphics2D.setFont(minecraft);
        graphics2D.setColor(Color.white);
        if(gamePanel.gameState==gamePanel.playState)
        {

        }
        if(gamePanel.gameState==gamePanel.pauseState)
        {
            gamePanel.stopMusic();
            drawPauseScreen();
        }
        if(gamePanel.gameState==gamePanel.titleState)
        {

            drawTitleScreen();
        }
        if(gamePanel.gameState==gamePanel.ruleState)
        {
            drawRuleScreen();


        }



    }
    public void drawRuleScreen()
    {
        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fillRect(0,0,gamePanel.screenWidth,gamePanel.screenHeight);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,30));
        String text = "RULES: ";
        int x = 48;
        int y = gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+1,y+1);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);


        // NO 1
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,15));
        text = "1. You have to search for a specific word in the map";
        x = 48;
        y+= gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+1,y+1);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);

        // no 2
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,15));
        text = "2. Player life will decrease if you eat letters that are not part of your given word.";
        x = 48;
        y+= gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+1,y+1);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,15));
        text = "3. Your word for this round is CLOUD";
        x = 48;
        y+= gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+1,y+1);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);







    }
    public void drawTitleScreen()  {
        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fillRect(0,0,gamePanel.screenWidth,gamePanel.screenHeight);
        // TITLE NAME


        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,80));
        String text = "SNEAKY";
        int x = getXforCenteredText(text);
        int y = gamePanel.tileSize*3;
        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+5,y+5);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);

        // display image
        x = gamePanel.screenWidth/2 - (gamePanel.tileSize*2)/2;
        y += gamePanel.tileSize*2;
        graphics2D.drawImage(gamePanel.player.down1,x,y,gamePanel.tileSize*2,gamePanel.tileSize*2,null);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,30));
        text = "PLAY GAME";
        x = getXforCenteredText(text);
        y+= gamePanel.tileSize*3.5;
        //shadow
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+3,y+3);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);

        if(commandNumber==0)
        {
            graphics2D.drawString(">",x-gamePanel.tileSize,y);
        }

        text = "RULES";
        x = getXforCenteredText(text);
        y+= gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+3,y+3);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);
        if(commandNumber==1)
        {
            graphics2D.drawString(">",x-gamePanel.tileSize,y);
        }



        text = "QUIT";
        x = getXforCenteredText(text);
        y+= gamePanel.tileSize;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(text,x+3,y+3);
        // MAIN COLOR
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text,x,y);

        if(commandNumber==2)
        {
            graphics2D.drawString(">",x-gamePanel.tileSize,y);
        }


    }
    public void drawPauseScreen()
    {
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN,80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gamePanel.screenHeight/2;
        graphics2D.drawString(text,x,y);
    }
    public int getXforCenteredText(String text)
    {
        int length = (int)graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
        int x = gamePanel.screenWidth/2 - length/2;
        return x;
    }
    public void showMessage(String message)
    {
        this.message = message;
        messageOn = true;
    }


}
