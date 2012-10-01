/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import timeline.entity.GameObject;
import timeline.entity.behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class GamePanel extends JPanel{
    public GamePanel(){
        this.setVisible(true);
        this.setBackground(Color.BLUE);
        this.setSize(800, 600);
    }
    
    public void draw(Graphics2D g2d){
        GameMain.mapa.draw(g2d);
        for(GameObject obj: GameMain.objetos){
            if(obj instanceof isDrawable){
                isDrawable objd = (isDrawable) obj;   
                objd.draw(g2d);
            }
        }
    }
}
