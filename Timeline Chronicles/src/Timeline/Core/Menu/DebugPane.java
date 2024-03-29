/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Menu;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import Timeline.Core.GameMain;
import Timeline.Core.Level.LevelLoader;

/**
 *
 * @author Lennon
 */
public class DebugPane extends Canvas {
    private BufferStrategy strategy;
    
    public DebugPane(){
      this.setVisible(true);
      this.setSize(100,100);
    }  
    
    public void draw(){
        if(strategy == null){
            this.createBufferStrategy(2);
            strategy = this.getBufferStrategy();
        }
       Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
       g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
       Font f = new Font("Arial", 10, 30);
       g2d.setFont(f);
       g2d.drawString("FPS:" + GameMain.getInstance().fps + " Estado do jogo: " + GameMain.getInstance().getGameState().toString() + " objLista:" + GameMain.objetos.size() + " vida:" + LevelLoader.getInstance().getLevel().getVida() + " " + LevelLoader.getInstance().getSpawner().getTempoSpawn(),50,50);
       
       //g2d.drawString(, 1, 1);
       g2d.dispose();
       strategy.show();
    }
}
