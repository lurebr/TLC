/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timelineeditor;

import com.sun.org.apache.bcel.internal.util.Class2HTML;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Lennon
 */
public class Image {
    private static Image instancia;
    
    public static Image getInstance(){
        if(instancia == null){
            instancia = new Image();
        }
        return instancia;
    }
    
    private Image(){
    }
    
    public BufferedImage getResourceImage(String caminho){
        URL url = getClass().getClassLoader().getResource(caminho);
        
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return imagem;
    }

}
