/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Desenv01
 */
public class Posicao implements Cloneable{
    private double x;
    private double y;

    public Posicao(){
        
    }
            
    public Posicao(Posicao localizacao) {
        this.x = localizacao.x;
        this.y = localizacao.y;
    }

    /**
     * @return the x
     */
    public double  getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    
    public String toString(){
        return "X: " + this.x + " Y: " + this.y;
    }
   public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }  
}
