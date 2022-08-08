package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener
{
    GamePanel gamePanel;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public KeyHandler(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
        // no use
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        // TITLE STATE

        if(gamePanel.gameState == gamePanel.titleState)
        {
            if(code==KeyEvent.VK_UP)
            {
                gamePanel.ui.commandNumber--;
                if(gamePanel.ui.commandNumber<0)
                {
                    gamePanel.ui.commandNumber=2;
                }
            }
            else if(code==KeyEvent.VK_DOWN)
            {
               gamePanel.ui.commandNumber++;
                if(gamePanel.ui.commandNumber>2)
                {
                    gamePanel.ui.commandNumber=0;
                }
            }
            else if(code==KeyEvent.VK_ENTER)
            {
                if(gamePanel.ui.commandNumber==0)
                {
                    gamePanel.gameState = gamePanel.playState;
                    gamePanel.playMusic(5);
                }
                else if(gamePanel.ui.commandNumber==1)
                {
                    gamePanel.gameState = gamePanel.ruleState;

                }
                else if(gamePanel.ui.commandNumber==2)
                {
                    System.exit(0);
                }

            }
        }

        if(code==KeyEvent.VK_UP)
        {
            upPressed = true;
        }
        else if(code==KeyEvent.VK_DOWN)
        {
            downPressed = true;
        }
        else if(code==KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }
        else if(code==KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
        else if(code==KeyEvent.VK_SPACE)
        {
            if(gamePanel.gameState==gamePanel.playState)
            {
                gamePanel.gameState = gamePanel.pauseState;;
            }
            else if(gamePanel.gameState==gamePanel.pauseState)
            {
                gamePanel.gameState = gamePanel.playState;
            }
        }


    }
    public void check(KeyEvent e)
    {
        if(gamePanel.gameState== gamePanel.ruleState)
        {
            gamePanel.gameState = gamePanel.titleState;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_UP)
        {
            upPressed = false;
        }
        else if(code==KeyEvent.VK_DOWN)
        {
            downPressed = false;
        }
        else if(code==KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }
        else if(code==KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }

    }
}