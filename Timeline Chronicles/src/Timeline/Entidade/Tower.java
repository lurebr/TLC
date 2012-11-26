/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import Timeline.Entidade.Shot.Shot;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Timeline.Imagem.Animacao;
import Timeline.Imagem.Imagem;
import Timeline.Core.GameMain;
import Timeline.Core.Sound.Player.SoundFactory;
import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Behavior.isAttackable;
import Timeline.Entidade.Behavior.isAttacker;
import Timeline.Entidade.Behavior.isColide;
import Timeline.Entidade.Behavior.isDrawable;
import Timeline.Entidade.Behavior.isSelectable;
import Timeline.Util.Componente.BarraDeAcao;

/**
 *
 * @author Desenv01
 */
public class Tower extends GameObject implements isAttacker, isDrawable, isColide, isSelectable, Cloneable {
private boolean selected ;
private int range;
private double preco;
private isAttackable alvo;
private int c = 100;
private int critico = 30;
private int atkSpeed = 100;
private int atkSpeedDelay=0;
private BarraDeAcao barraDeAcao;

    public Tower(String caminho,double posX, double posY, Atributo atributo){
        BufferedImage imagem = Imagem.getInstance().getResourceImage(caminho);
        
        super.animacao = new Animacao(imagem);
        super.localizacao.setX(posX);
        super.localizacao.setY(posY);
        super.tamanho.setHeight(imagem.getHeight());
        super.tamanho.setWidth(imagem.getWidth());
        super.atributo = atributo;
        range = 100;
        this.barraDeAcao = new BarraDeAcao(this.atkSpeed);
    }
    
    public Tower(String caminho, double preco){
        
        this.preco = preco;
        range = 10;
    }
   @Override  
    public Object clone() throws CloneNotSupportedException {  
        Tower copia = (Tower) super.clone();  
        return copia;  
   }
     
    @Override
    public void update(double delta) {
        
        if(atkSpeedDelay == atkSpeed){
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
        }else{
            atkSpeedDelay++;
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
    //    if(c == atkSpeed){
            c = 0;
            //System.out.println("NovoProjetil");
            //C:/Users/Lennon/Documents/NetBeansProjects/timeline-chronicles/Timeline Chronicles/src/Ressource/
            SoundFactory.getSoundPlayer().tocarEfeito("Ressource/Sound/shot.wav");
            Shot p = new Shot(alvo,this);
            GameMain.objetos.add(p);
      //  }
     //   c++;
        atkSpeedDelay= 0;
        return true;
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, (int)super.localizacao.getX(), (int)super.localizacao.getY());
        //g.drawRect((int) super.localizacao.getX() - range, (int) super.localizacao.getY() -range, range*2, range*2);
        //System.out.println("X: " + super.localizacao.getX() + " Y:" + super.localizacao.getY());
        this.barraDeAcao.draw(g, (int)super.localizacao.getX(), (int)super.localizacao.getY(), super.tamanho.getWidth(), super.tamanho.getHeight(), atkSpeedDelay);
        if(selected){
            Graphics2D g2d= (Graphics2D)g;
            g2d.drawOval((int)super.localizacao.getX(),(int) super.localizacao.getY(), range, range);
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
    public String Select() {
        String selectText;
        selectText = "Atk:" + this.atributo.getDanoMinimo() + "-" + this.atributo.getDanoMaximo();
        selectText += "\nSpeed:" + this.atkSpeed;
        return selectText;
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
    public Atributo getAtributo() {
        return super.atributo;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
