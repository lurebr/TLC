/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.atributes;

/**
 *
 * @author Desenv01
 */
public class Dimensao {
    private int width;
    private int height;
    
    public Dimensao(){
         
    }

    public Dimensao(Dimensao tamanho) {
        this.width = tamanho.width;
        this.height = tamanho.height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    public String toString(){
        return "Height: " + this.height + " Width: " + this.width;
    }

    
}
