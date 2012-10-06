/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import timeline.Image.Animacao;
import timeline.Image.Image;
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
    
     public Minion(String caminhoImagem,int[] movimento,int posX, int posY){
        this.movimento= movimento;
        posAtual = 0;
        BufferedImage imagem = Image.getInstance().getResourceImage(caminhoImagem);
        super.animacao = new Animacao(imagem);
        super.localizacao.setX(posX);
        super.localizacao.setY(posY);
        super.tamanho.setHeight(imagem.getHeight());
        super.tamanho.setWidth(imagem.getWidth());
     }

    @Override
    public void update() {
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

    @Override
    public void calculaDano(int dano) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g) {
         super.animacao.draw(g, super.localizacao.getX(), super.localizacao.getY());
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

    @Override
    public Localizacao getLocation() {
        return this.localizacao;
    }

    @Override
    public Dimensao getDimension() {
        return super.tamanho;
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
    
}
