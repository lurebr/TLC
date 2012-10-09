/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.j3d.Sound;
import timeline.Image.Animacao;
import timeline.Image.Image;
import timeline.core.GameMain;
import timeline.entity.atributes.Dimensao;
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
private isAttackable alvo;

    public Tower(String caminho,int posX, int posY){
        BufferedImage imagem = Image.getInstance().getResourceImage(caminho);
        
        super.animacao = new Animacao(imagem);
        super.localizacao.setX(posX);
        super.localizacao.setY(posY);
        super.tamanho.setHeight(imagem.getHeight());
        super.tamanho.setWidth(imagem.getWidth());
        range = 100;
    }
    
    public Tower(String caminho, double preco){
        
        this.preco = preco;
        range = 10;
    }
     
    @Override
    public void update() {
        
        if(alvo != null){
            if (attack(alvo)){
                return;
            }
        }
         for(GameObject obj: GameMain.objetos){
            if(obj instanceof isColide ){
                if (colide((isColide)obj)){
                    if(alvo == null && obj instanceof isAttackable){
                        attack((isAttackable) obj);
                    }
                }
            }
         }
        
    }

    @Override
    public boolean attack(isAttackable alvo) {
        if(!colide((isColide)alvo)){
            return false;
        }
        
        return true;
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
        g.drawRect( super.localizacao.getX() - range,  super.localizacao.getY() -range, range*2, range*2);
        //System.out.println("X: " + super.localizacao.getX() + " Y:" + super.localizacao.getY());
        if(selected){
            Graphics2D g2d= (Graphics2D)g;
            g2d.drawOval(super.localizacao.getX(), super.localizacao.getY(), range, range);
        }
    }

    @Override
    public boolean colide(isColide obj) {
        if(obj.getLocation().getX() >= this.localizacao.getX() - this.range &&  obj.getLocation().getX() <= + this.localizacao.getX() + this.range && 
           obj.getLocation().getY() >= this.localizacao.getY() - this.range &&  obj.getLocation().getY() <= + this.localizacao.getY() + this.range     
                ){
            System.out.println("colidiu");
            return true;
        }else{
            System.out.println("N Colidiu");
        }
            
        return false;
    }

    @Override
    public Localizacao getLocation() {
        return this.localizacao;
    }

    @Override
    public Dimensao getDimension() {
        return super.tamanho;
    }

    @Override
    public void Select(int x, int y) {
        this.selected = true;
    }


}
