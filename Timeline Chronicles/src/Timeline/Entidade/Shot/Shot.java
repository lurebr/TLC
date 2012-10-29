/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Shot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import Timeline.Core.GameMain;
import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Dano;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Behavior.isAttack;
import Timeline.Entidade.Behavior.isAttackable;
import Timeline.Entidade.Behavior.isAttacker;
import Timeline.Entidade.Behavior.isColide;
import Timeline.Entidade.Behavior.isDrawable;
import Timeline.Entidade.Elemento.Elemento;
import Timeline.Entidade.GameObject;
import Timeline.Util.Matematica.Matematica;

/**
 *
 * @author Beatriz B
 */
public class Shot extends GameObject implements isDrawable, isAttack, isColide {
    
    private isAttackable alvo;
    private boolean acertou;
    private int lastmove=0;
    private isAttacker atacante;
    private boolean calculou;
    private Elemento elemento;
    
    public Shot(isAttackable alvo, isAttacker atacante) {
        this.alvo = alvo;
        this.acertou = false;        
        this.atacante = atacante;
      // this.elemento = elemento;
        super.localizacao = new Posicao(atacante.getLocalizacao());
        super.tamanho = new Tamanho(atacante.getTamanho());
        super.atributo = new Atributo(atacante.getAtributo());
        
    }
    
    @Override
    public void update() {
      
        if(alvo.isAlive() && this.acertou && this.calculou== false){
            alvo.calculaDano(this.getDamage());
            calculou = true;
        }else if(alvo.isAlive() && this.acertou == false){
           
            mover();
        }else{
            GameMain.objetos.remove(this);
        }
    }
    
    private void mover(){
         if (acertou == false){
            int speed = 2;
            if(alvo.getLocalizacao().getX() != super.localizacao.getX()){
                if(alvo.getLocalizacao().getX()> super.localizacao.getX()){
                    super.localizacao.setX(super.localizacao.getX() +speed);
                }
                else if(alvo.getLocalizacao().getX()< super.localizacao.getX()){
                    super.localizacao.setX(super.localizacao.getX() -speed);
                }

            }
            if(alvo.getLocalizacao().getY() != super.localizacao.getY()){
                if(alvo.getLocalizacao().getY()> super.localizacao.getY()){
                    super.localizacao.setY(super.localizacao.getY() +speed);
                }
                else if(alvo.getLocalizacao().getY()< super.localizacao.getY()){
                    super.localizacao.setY(super.localizacao.getY() -speed);
                }
            }
            if(alvo.getLocalizacao().getX() == super.localizacao.getX() && alvo.getLocalizacao().getY() == super.localizacao.getY()){
                acertou = true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        
        //super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
        if(!acertou){
           
            g.setColor(Color.red);
            g.drawLine(super.localizacao.getX(), super.localizacao.getY(), super.localizacao.getX()+10, super.localizacao.getY());    
            g.setColor(Color.black);
        }
        
    }

    @Override
    public Dano getDamage() {
        int danoTotal;
        Dano dano = new Dano();
        dano.setDanoProjetil(Matematica.getInstance().getRandom(super.atributo.getDanoMinimo(), super.atributo.getDanoMaximo()));
        
        return dano;
    }

    @Override
    public boolean colide(isColide obj) {
        return Matematica.getInstance().colidir(obj,this);
    }

    @Override
    public Posicao getLocalizacao() {
        return super.localizacao;
    }

    @Override
    public Tamanho getTamanho() {
        return super.tamanho;
    }

    
}
