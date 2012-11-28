/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Util.Componente;

import Timeline.Entidade.Behavior.isDrawable;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Lennon
 */
public class BarraDeVida implements isDrawable{
    private int vidaMax;
    
    public BarraDeVida(int vidaMax){
        this.vidaMax = vidaMax;
    }

    @Override
    public void draw(Graphics g) {
        //do nothing
    }

    public void draw(Graphics g, int x, int y, int width, int height, int vidaAtual) {
         g.drawRect(x,y-20,width,10);
         g.setColor(Color.gray);
         g.fillRect(x,y - 20 , width ,10);
         
         int percent;
         percent = Math.abs(vidaAtual*100)/vidaMax;
         
         if(percent >= 70){
             g.setColor(Color.green);
         }else if(percent >= 50){
             g.setColor(Color.yellow);
         }else{
             g.setColor(Color.red);
         }
         
         int barVidaAtual;
         barVidaAtual = (int) (((float)percent/(float)100)*width);
         g.drawRect(x,y- 20 ,barVidaAtual,10);
         g.fillRect(x,y- 20 , barVidaAtual,10);
         
         g.setColor(Color.black);
    }

    /**
     * @param vidaMax the vidaMax to set
     */
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
    
   
}
