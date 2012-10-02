/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import sun.awt.image.OffScreenImage;
import timeline.entity.GameObject;
import timeline.entity.behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class GamePanel extends Canvas {
    BufferStrategy strategy;
    
    public GamePanel(){
       this.setVisible(true);
       this.setSize(800, 600);
      
    }
    
    public void draw(){
        if(strategy == null){
            this.createBufferStrategy(2);
            strategy = this.getBufferStrategy();
        }
        Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
        GameMain.mapa.draw(g2d);
        for(GameObject obj: GameMain.objetos){
            if(obj instanceof isDrawable){
                isDrawable objd = (isDrawable) obj;   
                objd.draw(g2d);
            }
        }
        g2d.dispose();
        strategy.show();
    }
}
