/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.atributes;

/**
 *
 * @author Desenv01
 */
public class Localizacao{
    private int x;
    private int y;

    public Localizacao(){
        
    }
            
    public Localizacao(Localizacao localizacao) {
        this.x = localizacao.x;
        this.y = localizacao.y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public String toString(){
        return "X: " + this.x + " Y: " + this.y;
    }
    
}
