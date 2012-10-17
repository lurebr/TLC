/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Desenv01
 */
public class Tamanho {
    private int width;
    private int height;
    
    public Tamanho(){
         
    }

    public Tamanho(Tamanho tamanho) {
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
