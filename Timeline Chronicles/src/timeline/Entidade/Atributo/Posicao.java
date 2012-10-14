/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Desenv01
 */
public class Posicao{
    private int x;
    private int y;

    public Posicao(){
        
    }
            
    public Posicao(Posicao localizacao) {
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
