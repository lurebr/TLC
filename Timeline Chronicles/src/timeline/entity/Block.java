/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import test.testTela;
import timeline.Image.Animacao;
import timeline.Image.Image;
import timeline.entity.behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class Block extends GameObject implements isDrawable {
    
    private int posX;
    private int posY;
    private int altura;
    private int largura;

    
    public Block(int typeBlock,int posX, int posY){
        BufferedImage imagem = Image.getInstance().getResourceImage(getCaminho(typeBlock));

        super.animacao = new Animacao(imagem);
        this.altura = imagem.getHeight();
        this.largura = imagem.getWidth();
        this.posX = posX;
        this.posY = posY;
    }
    
    private String getCaminho(int i) {
        switch (i){
            case 1:
                return "resource/object/block/grass.JPG";
            case 2:
                return "resource/object/block/earth.JPG";
            case 3:
                return "resource/object/block/grass.JPG";
            case 4:
                return "resource/object/block/grass.JPG";                
            default:
                return "";
        }
    }
    
    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, posY*altura, posX * largura);
    }
    
}
