/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

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
import Timeline.Imagem.Animacao;
import Timeline.Imagem.Imagem;
import Timeline.Entidade.Behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class Block extends GameObject implements isDrawable {
    
    private int posX;
    private int posY;
    private int altura;
    private int largura;
    private boolean allowTower;

    
    public Block(int typeBlock,int posX, int posY, boolean allowTower){
        BufferedImage imagem = Imagem.getInstance().getResourceImage(getCaminho(typeBlock));

        super.animacao = new Animacao(imagem);
        this.altura = imagem.getHeight();
        this.largura = imagem.getWidth();
        this.posX = posX;
        this.posY = posY;
        this.allowTower = allowTower;
    }
    
    private String getCaminho(int i) {
        switch (i){
            case 1:
                return "Ressource/Object/Block/grass.JPG";
            case 2:
                return "Ressource/Object/Block/earth.JPG";
            case 3:
                return "Ressource/Object/Block/earth.JPG";
            case 4:
                return "Ressource/Object/Block/earth.JPG";                
            default:
                return "";
        }
    }
    
    @Override
    public void update(double delta) {
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, posY*altura, posX * largura);
    }

    /**
     * @return the allowTower
     */
    public boolean isAllowTower() {
        return allowTower;
    }

    
}
