/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import timeline.Image.Animacao;
import timeline.Image.Image;
import timeline.core.GameMain;
import timeline.entity.atributes.Localizacao;
import timeline.entity.behavior.isAttackable;
import timeline.entity.behavior.isAttacker;
import timeline.entity.behavior.isColide;
import timeline.entity.behavior.isDrawable;
import timeline.entity.behavior.isSelectable;

/**
 *
 * @author Desenv01
 */
public class Tower extends GameObject implements isAttacker, isDrawable, isColide, isSelectable {
private boolean selected ;
private int range;
private double preco;
        
    public Tower(String caminho,int posX, int posY){
        BufferedImage imagem = Image.getInstance().getResourceImage(caminho);

        super.animacao = new Animacao(imagem);
        super.localizacao.setX(posX);
        super.localizacao.setY(posY);
        super.tamanho.setHeight(imagem.getHeight());
        super.tamanho.setWidth(imagem.getWidth());
        range = 400;
    }
    
    public Tower(String caminho, double preco){
        
        this.preco = preco;
        range = 400;
    }
     
    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void attack(isAttackable alvo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
        if(selected){
            Graphics2D g2d= (Graphics2D)g;
            g2d.drawOval(super.localizacao.getX(), super.localizacao.getY(), range, range);
        }
    }

    @Override
    public void colide(isColide obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Localizacao getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dimension2D getDimension() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Select(int x, int y) {
        this.selected = true;
    }


}
