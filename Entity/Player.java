package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;
    public int hasC, hasL, hasO, hasU, hasD;
    public Player(GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        screenX = gamePanel.screenWidth/2 - gamePanel.tileSize/2;
        screenY = gamePanel.screenHeight/2  - gamePanel.tileSize/2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;


        setDefaultValues();
        getPlayerImage();
    }
//    public void setDefaultPositions()
//    {
//        speed=6;
//        worldX = gamePanel.tileSize*25;
//        worldY = gamePanel.tileSize*17;
//        direction = "down";
//    }
//    public void restoreLife()
//    {
//        life = maxLife;
//
//
//    }

    /**
     * sets up default values of the player like speed, position, direction, life.
     */
    public void setDefaultValues()
    {

        worldX = gamePanel.tileSize*25;
        worldY = gamePanel.tileSize*17;
        speed = 6;
        direction = "down";
        // player status
        maxLife = 3;
        life = maxLife;
    }

    /**
     * loads sprite images
     */
    public void getPlayerImage()
    {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/down-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/left-2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/right-2.png"));


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * updates the player's positions based on keys pressed & checks for collisions with the tile & trees.
     */
    public void update()
    {
        if (keyHandler.upPressed == true ||
                keyHandler.downPressed == true ||
                keyHandler.leftPressed == true ||
                keyHandler.rightPressed == true) {
            if (keyHandler.upPressed) {
                direction = "up";


            } else if (keyHandler.downPressed) {
                direction = "down";

            } else if (keyHandler.leftPressed)
            {
                direction = "left";

            }
            else if (keyHandler.rightPressed)
            {
                direction = "right";
            }
            // CHECK TILE COLLISION
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);
            // CHECK OBJECT COLLISION
            int objIndex = gamePanel.collisionChecker.checkObject(this,true);
            pickUpObject(objIndex);
            if(collisionOn == false)
            {
                switch (direction)
                {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            /**
             * this part is used to display sprite characters as if it were an animation. two images have been used for each positions - left, right, down, up - so they are swapped after sometime to make it look like they're moving
             */
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    }

    /**
     *  the method checks if the sprite has collided the object , if so it makes changes to variables like speed, letter count, life.
     * @param i - accepts an index that describes which object it is.
     */
    public void pickUpObject(int i)
    {
        if(i!=999) {
            String objectName = gamePanel.obj[i].name;
            switch (objectName)
            {
                case "C":
                    gamePanel.playSoundEffect(0);
                    hasC++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You've got C!");
                    break;

                case "L":
                    gamePanel.playSoundEffect(0);
                    hasL++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You've got L!");
                    break;

                case "O":
                    gamePanel.playSoundEffect(0);
                    hasO++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You've got O!");
                    break;

                case "U":
                    gamePanel.playSoundEffect(0);
                    hasU++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You've got U!");
                    break;

                case "D":
                    gamePanel.playSoundEffect(0);
                    hasD++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You've got D!");
                    break;

                case "A":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "B":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "E":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "F":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "G":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "H":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "S":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "T":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;

                    case "K":
                        gamePanel.playSoundEffect(3);
                        speed-=2;
                        life--;
                        gamePanel.obj[i] = null;
                        break;
                case "I":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "J":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "M":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "N":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "Z":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "X":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;
                case "Insect":
                    gamePanel.playSoundEffect(1);
                    speed+=2;
                    gamePanel.obj[i] = null;
                    break;
                case "Acid":
                    gamePanel.playSoundEffect(3);
                    speed-=2;
                    life--;
                    gamePanel.obj[i] = null;
                    break;

            }
            /**
             * This part confirms that player has collected all the letters.
             */
            if(hasC == 1 && hasL == 1 && hasO == 1 && hasU == 1 && hasD == 1)
            {
//                gamePanel.ui.gameFinished = true;
                gamePanel.gameState = gamePanel.winState;
//               gamePanel.stopMusic();
                gamePanel.playSoundEffect(6);
            }
            /**
             * This part redirects to end of game.
             */
            if(speed==0 || life==0)
            {
                gamePanel.gameState = gamePanel.gameOverState;
                gamePanel.playSoundEffect(4);
            }
        }
    }

    /**
     * draws player characters based on the directions
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D)
    {
        BufferedImage image = null;
        switch(direction)
        {
            case "up":
                if(spriteNum==1)
                {
                    image = up1;
                }
                else if(spriteNum==2)
                {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum==1)
                {
                    image = down1;
                }
                else if(spriteNum==2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum==1)
                {
                    image = left1;
                }
                else if(spriteNum==2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum==1)
                {
                    image = right1;
                }
                else if(spriteNum==2)
                {
                    image = right2;
                }
                break;
        }
        graphics2D.drawImage(image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize, null);
    }
}
