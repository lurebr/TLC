/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Componente;

import Timeline.Core.GameMain;
import Timeline.Core.Level.LevelLoader;
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
import Timeline.Entidade.Tower;
import javax.swing.JOptionPane;

/**
 *
 * @author Lennon
 */
public class Mouse implements MouseListener, MouseMotionListener {
    private EnumEstadoMouse estado;
    private Tower t;
    
    public Mouse(){
        empty();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        switch(estado){
            case empty:
                colide(e.getX(), e.getY());
                break;
            case build:
                GameMain.getInstance().addTower(e.getX(), e.getY(), t);
                break;
            case display:  
                break;
        }
        
    }
    private boolean colide(int x, int y){
        
        for(Object o : GameMain.getInstance().objetos){
            if (o instanceof isSelectable){
                isSelectable s = (isSelectable)o;
                LevelLoader.getInstance().getStore().Select(s);
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

    /**
     * @param estado the estado to set
     */
    public void build(Tower t) {
        this.t = t;
        this.estado = EnumEstadoMouse.build;
    }

    public void empty() {
       this.t = null;
       this.estado = EnumEstadoMouse.empty;
    }
    
}
