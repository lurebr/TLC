/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import timeline.Image.Animacao;
import timeline.Image.Image;
import timeline.core.GameMain;
import timeline.entity.atributes.Atributo;
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
private int c = 100;

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
                        if(attack((isAttackable) obj)){
                           //break; 
                        }
                    }
                }
            }
         }
        
    }

    @Override
    public boolean attack(isAttackable alvo) {
        if(!colide((isColide)alvo) ||! alvo.isAlive()){
            //count++System.out.println("ja tem alvo");
            this.alvo = null;
            return false;
        }
        //System.out.println(c);
        if(c == 100){
            c = 0;
            //System.out.println("NovoProjetil");
            Projetil p = new Projetil(alvo,this);
            GameMain.objetos.add(p);
        }
        c++;
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
        if(obj.getLocalizacao().getX() >= this.localizacao.getX() - this.range &&  obj.getLocalizacao().getX() <= + this.localizacao.getX() + this.range && 
           obj.getLocalizacao().getY() >= this.localizacao.getY() - this.range &&  obj.getLocalizacao().getY() <= + this.localizacao.getY() + this.range     
                ){
           //System.out.println("colidiu");
            return true;
        }else{
           // System.out.println("N Colidiu");
        }
            
        return false;
    }

    @Override
    public void Select(int x, int y) {
        this.selected = true;
    }
    @Override
    public Localizacao getLocalizacao() {
        return super.localizacao;
    }

    @Override
    public Dimensao getTamanho() {
        return super.tamanho;
    }

    @Override
    public Atributo getAtributo() {
        return super.atributo;
    }

}
