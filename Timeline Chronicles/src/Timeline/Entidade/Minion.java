/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

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
import Timeline.Imagem.Animacao;
import Timeline.Imagem.Imagem;
import Timeline.Chronicles.Game;
import Timeline.Core.GameMain;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Behavior.isAttackable;
import Timeline.Entidade.Behavior.isColide;
import Timeline.Entidade.Behavior.isDrawable;
import Timeline.Entidade.Behavior.isWalkable;
import Timeline.Enumerador.EnumDirecao;
import Timeline.Core.Parametro;
import Timeline.Util.Componente.BarraDeVida;

/**
 *
 * @author Desenv01
 */
public class Minion extends GameObject implements isAttackable,isDrawable, isWalkable, isColide   {
    
    private int posicao;
    private EnumDirecao direcaoAtual;
    private int[] movimento;
    private int posAtual;
    private int count;
    private boolean vivo;
    private int gold;
    private BarraDeVida barraDeVida;
            
     public Minion(String caminhoImagem, int gold, int vidaMax){        
        this.movimento= null;
        posAtual = 0;
        
        BufferedImage imagem = Imagem.getInstance().getResourceImage(caminhoImagem);
        super.animacao = new Animacao(imagem);

        super.tamanho.setHeight(Parametro.SPRITE_HEIGHT);
        super.tamanho.setWidth(Parametro.SPRITE_WIDTH);        
        super.localizacao.setX(0);
        super.localizacao.setY(0);

        super.atributo.setVidaMax(vidaMax);
        super.atributo.setVida(vidaMax);
        this.barraDeVida = new BarraDeVida(super.atributo.getVidaMax());
        this.vivo = true;
        this.gold= gold;
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
         this.barraDeVida.draw(g, super.localizacao.getX(), super.localizacao.getY(), super.tamanho.getWidth(), super.tamanho.getHeight(), super.atributo.getVida());
        }
    }

    @Override
    public void move() {
        System.out.println(direcaoAtual);
        switch(direcaoAtual){
                case cima:
                   super.localizacao.setY(super.localizacao.getY()-1);
                   super.animacao.mudarEstilo(3);
                    break;
                case baixo:
                   super.localizacao.setY(super.localizacao.getY()+1);
                   super.animacao.mudarEstilo(0);
                    break;
                case direita:
                   super.localizacao.setX(super.localizacao.getX()-1);
                   super.animacao.mudarEstilo(1);
                    break;
                case esquerda:
                   super.localizacao.setX(super.localizacao.getX()+1);
                   super.animacao.mudarEstilo(2);
                    break;
                case parado:
                    break;
        }
    }
    @Override
    public void move(EnumDirecao direcao) {
        this.direcaoAtual = direcao;
        move();
    }

   
        public EnumDirecao getDirecao(int posicao) {
            switch (posicao){
                case 0:
                   return EnumDirecao.parado;
                case 1:
                   return EnumDirecao.cima;
                case 2:
                   return EnumDirecao.baixo; 
                case 3:
                   return EnumDirecao.direita; 
                case 4:
                   return EnumDirecao.esquerda; 
                default:
                   return EnumDirecao.cima;
            }
    }

    @Override
    public boolean colide(isColide obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Posicao getLocalizacao() {
        return super.localizacao;
    }

    @Override
    public Tamanho getTamanho() {
        return super.tamanho;
    }

    @Override
    public boolean isAlive() {
        return vivo;
    }

    /**
     * @param movimento the movimento to set
     */
    public void setMovimento(int[] movimento) {
        this.movimento = movimento;
    }

   
}
