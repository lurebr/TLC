/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Imagem;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Timeline.Core.Parametro;


/**
 *
 * @author Desenv01
 */
public class Animacao{
    private Map<String, List<BufferedImage>> listaImagem;
    private int frameAtual = 0;
    private int estilo = 0;
    private int nSpriteY;
    private int nSpriteX;
    
    public Animacao(){
    }
    public Animacao(BufferedImage sprite){
        
        listaImagem = new HashMap<String, List<BufferedImage>>();
        nSpriteY = (int) sprite.getHeight() / Parametro.SPRITE_HEIGHT;
        nSpriteX = (int) sprite.getWidth() / Parametro.SPRITE_WIDTH;
        List<BufferedImage> sprites = new ArrayList<BufferedImage>();
        
        for (int i=0;i<nSpriteY;i++){
    
            for(int x=0;x<nSpriteX;x++){
                 BufferedImage b = sprite.getSubimage(Parametro.SPRITE_WIDTH*x,Parametro.SPRITE_HEIGHT*i, Parametro.SPRITE_WIDTH,Parametro.SPRITE_HEIGHT );
                 sprites.add(b);
            }
            listaImagem.put(Integer.toString(i), sprites);
        }
    }
    
    public void mudarEstilo(int estilo){
        if(this.estilo != estilo){
            this.estilo = estilo;    
            this.frameAtual = 0;
        }
    }
    
    public void draw(Graphics g, int x,int y) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage imagem = listaImagem.get(Integer.toString(estilo)).get(frameAtual);
        g2d.drawImage(imagem ,x,y, null );
    }
    
}
