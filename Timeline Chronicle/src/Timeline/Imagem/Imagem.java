/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Imagem;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Lennon
 */
public class Imagem {
    private static Imagem instancia;
    
    public static Imagem getInstance(){
        if(instancia == null){
            instancia = new Imagem();
        }
        return instancia;
    }
    
    private Imagem(){
    }
    
    public BufferedImage getResourceImage(String caminho){
        URL url = getClass().getResource(caminho);
        
        BufferedImage bfImagem = null;
        try {
//            Image imagem = Toolkit.getDefaultToolkit().getImage(url);
            bfImagem = ImageIO.read(url.openStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bfImagem;
    }
}
