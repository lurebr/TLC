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
public class BarraDeAcao implements isDrawable{
    private int valorMax;
    
    public BarraDeAcao(int valorMax){
        this.valorMax = valorMax;
    }

    @Override
    public void draw(Graphics g) {
        //do nothing
    }

    public void draw(Graphics g, int x, int y, int width, int height, int valorAtual) {
         
         g.drawRect(x,y-20,width,5);
         g.setColor(Color.gray);
         g.fillRect(x,y - 20 , width ,5);
         
         int percent;
         percent = Math.abs(valorAtual*100)/valorMax;
         
         g.setColor(Color.cyan);
         
         int barVidaAtual;
         barVidaAtual = (int) (((float)percent/(float)100)*width);
         g.drawRect(x,y-20 ,barVidaAtual,5);
         g.fillRect(x,y-20 , barVidaAtual,5);
         
         g.setColor(Color.black);
    }

    /**
     * @param vidaMax the vidaMax to set
     */
    public void setValorMax(int valorMax) {
        this.valorMax = valorMax;
    }
    
   
}
