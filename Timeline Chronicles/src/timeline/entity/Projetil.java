/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;
import timeline.entity.behavior.isAttack;
import timeline.entity.behavior.isAttackable;
import timeline.entity.behavior.isColide;
import timeline.entity.behavior.isDrawable;

/**
 *
 * @author Beatriz B
 */
public class Projetil extends GameObject implements isDrawable, isAttack, isColide {
    
    private isAttackable alvo;
    private boolean acertou;
    public Projetil(isAttackable alvo){
        this.alvo = alvo;
        acertou = false;
    }
    
    @Override
    public void update() {
      
        if(alvo.getLocalizacao().getX() != super.localizacao.getX()){
            if(alvo.getLocalizacao().getX()> super.localizacao.getX()){
                super.localizacao.setX(super.localizacao.getX() +1);
            }
            else if(alvo.getLocalizacao().getX()< super.localizacao.getX()){
                super.localizacao.setX(super.localizacao.getX() -1);
            }
            
        }
        if(alvo.getLocalizacao().getY() != super.localizacao.getY()){
            if(alvo.getLocalizacao().getY()> super.localizacao.getY()){
                super.localizacao.setY(super.localizacao.getY() +1);
            }
            else if(alvo.getLocalizacao().getY()< super.localizacao.getY()){
                super.localizacao.setY(super.localizacao.getY() -1);
            }
        }
        if(alvo.getLocalizacao().getX() == super.localizacao.getX() && alvo.getLocalizacao().getY() == super.localizacao.getY()){
            acertou = true;
        }
           
    }

    @Override
    public void draw(Graphics g) {
        //super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
        if(!acertou){
            g.drawLine(super.localizacao.getX(), super.localizacao.getY(), super.localizacao.getX(), super.localizacao.getY()+ 10);    
        }
    }

    @Override
    public int getDamage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean colide(isColide obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Localizacao getLocation() {
        return super.localizacao;
    }

    @Override
    public Dimensao getDimension() {
        return super.tamanho;
    }
    
}
