/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Lennon
 */
public final class testTela {
    public static JFrame j = new JFrame();

    public static int x;
    
    public  testTela(){
                 

                 
                 
    }
    public static void draw(BufferedImage sprite){
        x += 10;
        if (x == 200)
            x = 10;
        
                         j.setVisible(true);
                 j.setSize(800,600);
        Graphics2D g2d = (Graphics2D) j.getGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 800, 600);
        g2d.drawImage(sprite,50,50+x,null);
    }
}
