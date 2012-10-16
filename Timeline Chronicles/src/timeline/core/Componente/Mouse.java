/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Core.Componente;

import timeline.Core.GameMain;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import Timeline.Entidade.Behavior.isColide;
import Timeline.Entidade.Behavior.isSelectable;

/**
 *
 * @author Lennon
 */
public class Mouse implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      //  if (colide(e.getX(), e.getY())){
            GameMain.getInstance().addTower(e.getX(), e.getY());
     //   }
    }
    private boolean colide(int x, int y){
        
        for(Object o : GameMain.getInstance().objetos){
            if (o instanceof isSelectable){
                isSelectable c = (isSelectable)o;
                c.Select(x,y);                
            }
        }
        return true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
}
