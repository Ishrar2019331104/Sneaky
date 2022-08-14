package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    GamePanel gamePanel;

    public MouseHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e){
        int code = e.getButton();
        System.out.println(code);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        int code = e.getButton();
//        System.out.println(code);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
