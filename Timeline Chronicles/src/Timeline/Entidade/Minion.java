/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Timeline.Imagem.Animacao;
import Timeline.Imagem.Imagem;
import Timeline.Chronicles.Game;
import Timeline.Core.GameMain;
import Timeline.Core.Level.LevelLoader;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Behavior.isAttackable;
import Timeline.Entidade.Behavior.isColide;
import Timeline.Entidade.Behavior.isDrawable;
import Timeline.Entidade.Behavior.isWalkable;
import Timeline.Enumerador.EnumDirecao;
import Timeline.Core.Parametro;
import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Dano;
import Timeline.Util.Componente.BarraDeVida;
import Timeline.Util.Matematica.Matematica;
import java.util.HashMap;

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
    private HashMap<Integer,Integer> danoTomado = new HashMap<Integer,Integer>();
            
     public Minion(String caminhoImagem, int gold, int vidaMax, Atributo atributo){        
        this.movimento= null;
        posAtual = 0;
        
        BufferedImage imagem = Imagem.getInstance().getResourceImage(caminhoImagem);
        super.animacao = new Animacao(imagem);

        super.tamanho.setHeight(Parametro.SPRITE_HEIGHT);
        super.tamanho.setWidth(Parametro.SPRITE_WIDTH);        
        super.localizacao.setX(0);
        super.localizacao.setY(0);

        super.atributo = atributo;
        
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
            if(count==32 && posAtual < movimento.length){
                posAtual++;
                count = 0;
            }
            if(posAtual == movimento.length){
                //direcaoAtual = getDirecao(0);
                LevelLoader.getInstance().getLevel().DiminuiVida();
                GameMain.objetos.remove(this);
            }
            move();        
        }
    }
 
   @Override
   public void calculaDano(Dano dano) {
        int danoTotal = Matematica.getInstance().calculaDano(dano, super.atributo);
        GameMain.pintaTexto.setTexto(danoTotal, super.localizacao);
        System.out.println("Evasion: "+danoTotal);
        //calculaDano(dano);
        this.atributo.setVida(this.atributo.getVida() -danoTotal);
            if(this.atributo.getVida() <= 0){
                this.vivo = false;
                Game.jogador.setGold(Game.jogador.getGold() + this.gold);
                GameMain.objetos.remove(this);
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
        //System.out.println("Direcao:" + super.localizacao.toString());
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
        return Matematica.getInstance().colidir(obj, this);
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

    public void setPosicaoInicial(Posicao spawnLocation) {
        super.localizacao.setX(spawnLocation.getX());
        super.localizacao.setY(spawnLocation.getY());
    }

    @Override
    public Atributo getAtributo() {
        return super.atributo;
    }
  
}
