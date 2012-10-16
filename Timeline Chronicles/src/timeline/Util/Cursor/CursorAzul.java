/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Util.Cursor;

import Timeline.Imagem.Imagem;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Lennon
 */
public class CursorAzul implements ICursor {
    protected CursorAzul(){}
    @Override
    public void mudarCursor(JFrame tela) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
        BufferedImage cursor =  Imagem.getInstance().getResourceImage("ressource/system/cursor/cursor.png");
        Cursor c = toolkit.createCustomCursor(cursor,cursorHotSpot,"Cursor");
        tela.setCursor(c);
        
        // int mx = MouseInfo.getPointerInfo().getLocation().x;
       // int my = MouseInfo.getPointerInfo().getLocation().y;
        //g.drawString("mx: " + mx + " my: " + my,0, 100);
       // int posx = Math.round(mx/32)*32;
       // int posy = Math.round(my/32)*32;
    }
    
}
 