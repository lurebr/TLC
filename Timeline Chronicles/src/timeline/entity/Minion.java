/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import timeline.Image.Animacao;
import timeline.Image.Image;
import timeline.core.Game;
import timeline.core.GameMain;
import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;
import timeline.entity.behavior.isAttackable;
import timeline.entity.behavior.isColide;
import timeline.entity.behavior.isDrawable;
import timeline.entity.behavior.isWalkable;
import timeline.enumerators.eDirecao;

/**
 *
 * @author Desenv01
 */
public class Minion extends GameObject implements isAttackable,isDrawable, isWalkable, isColide   {
    
    private int posicao;
    private eDirecao direcaoAtual;
    private int[] movimento;
    private int posAtual;
    private int count;
    private boolean vivo;
    private int gold;
    
     public Minion(String caminhoImagem,int[] movimento,int posX, int posY){
        this.movimento= movimento;
        posAtual = 0;
        BufferedImage imagem = Image.getInstance().getResourceImage(caminhoImagem);
        super.animacao = new Animacao(imagem);
        super.localizacao.setX(posX);
        super.localizacao.setY(posY);
        super.tamanho.setHeight(imagem.getHeight());
        super.tamanho.setWidth(imagem.getWidth());
        super.atributo.setVidaMax(100);
        super.atributo.setVida(100);
        this.vivo = true;
        this.gold= 10;
     }

    @Override
    public void update() {
        
        if(this.vivo){
            if(this.atributo.getVida() <= 0){
                this.vivo = false;
            }
            direcaoAtual= getDirecao(movimento[posAtual]);
            count++;
            if(count==32 && posAtual < movimento.length-1){
                posAtual++;
                count = 0;
            }
            if(posAtual == movimento.length-1){
                direcaoAtual = getDirecao(0);
            }
            move();        
        }
    }

    @Override
    public void calculaDano(int dano) {
        this.atributo.setVida(this.atributo.getVida() -dano);
            if(this.atributo.getVida() <= 0){
                this.vivo = false;
                Game.jogador.setGold(Game.jogador.getGold() + this.gold);
            }
    }

    @Override
    public void draw(Graphics g) {
        if (this.vivo){
         super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
         Rectangle rec = new Rectangle();
         g.drawRect(super.localizacao.getX(),super.localizacao.getY()- 20 , super.tamanho.getWidth(),10);
         g.setColor(Color.gray);
         g.fillRect(super.localizacao.getX(),super.localizacao.getY()- 20 , super.tamanho.getWidth(),10);
         
         int percent;
         percent = Math.abs(super.atributo.getVida()*100)/super.atributo.getVidaMax();
         System.out.println("Percent: " + percent + "%");
         if(percent >= 70){
             g.setColor(Color.green);
         }else if(percent >= 50){
             g.setColor(Color.yellow);
         }else{
             g.setColor(Color.red);
         }
         int vidaAtual;
         vidaAtual = (int) (((float)percent/(float)100)*super.tamanho.getWidth());
         System.out.println(percent + " " + (float)(percent/100) + " " + super.tamanho.getWidth() + " " + vidaAtual);
         g.drawRect(super.localizacao.getX(),super.localizacao.getY()- 20 ,vidaAtual,10);
         g.fillRect(super.localizacao.getX(),super.localizacao.getY()- 20 , vidaAtual,10);
         
         g.setColor(Color.black);
      
        }
    }

    @Override
    public void move() {
        switch(direcaoAtual){
                case cima:
                   super.localizacao.setY(super.localizacao.getY()-1);
                    break;
                case baixo:
                   super.localizacao.setY(super.localizacao.getY()+1);
                    break;
                case direita:
                   super.localizacao.setX(super.localizacao.getX()-1);
                    break;
                case esquerda:
                   super.localizacao.setX(super.localizacao.getX()+1);
                    break;
                case parado:
                    break;
        }
    }

    @Override
    public void move(eDirecao direcao) {
        this.direcaoAtual = direcao;
        move();
    }

   
        public eDirecao getDirecao(int posicao) {
            switch (posicao){
                case 0:
                   return eDirecao.parado;
                case 1:
                   return eDirecao.cima;
                case 2:
                   return eDirecao.baixo; 
                case 3:
                   return eDirecao.direita; 
                case 4:
                   return eDirecao.esquerda; 
                default:
                   return eDirecao.cima;
            }
    }

    @Override
    public boolean colide(isColide obj) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public boolean isAlive() {
        return vivo;
    }
    
}
